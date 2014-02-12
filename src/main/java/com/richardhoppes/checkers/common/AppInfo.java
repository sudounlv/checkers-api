package com.richardhoppes.checkers.common;

import com.richardhoppes.checkers.exception.PropertyNotFoundException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class AppInfo implements ServletContextAware {

	static final String MANIFEST_IMPLEMENTATION_BUILD = "Implementation-Build";
	static final String MANIFEST_IMPLEMENTATION_VERSION = "Implementation-Version";
	static final String MANIFEST_BUILD_TIME = "Build-Time";
	static final String MANIFEST_PACKAGE = "Package";
	static final String BAD_HASH = "BAD_HASH";

	private ServletContext servletContext;
	private Manifest manifest;
	private String buildIdentifierHash;

	protected Manifest getManifest() {
		if (this.manifest == null) {
			this.manifest = new Manifest();

			try {
				String manifestFilePath = this.servletContext.getRealPath("/") + "/META-INF/MANIFEST.MF";
				//log.info("Reading manifest file from " + manifestFilePath);
				File manifestFile = new File(manifestFilePath);
				FileInputStream fileInputStream = new FileInputStream(manifestFile);
				this.manifest.read(fileInputStream);
				fileInputStream.close();
			} catch (IOException ex) {
				//log.warn("Unable to open manifest.  Please validate your configuration.");
			}
		}

		return this.manifest;
	}

	protected String getManifestEntry(String entry) throws PropertyNotFoundException {
		String retVal = null;

		try {
			Manifest manifest = getManifest();
			if (manifest != null) {
				Attributes atts = manifest.getMainAttributes();
				if (atts != null && !atts.isEmpty()) {
					retVal = atts.getValue(entry);
					//log.debug("Got entry {} from manifest.", entry);
				}
			}
		} catch (Exception ex) {
			throw new PropertyNotFoundException("Unable to get entry from manifest.  Please validate your configuration.");
		}

		if (retVal == null) {
			throw new PropertyNotFoundException("Unable to find the requested manifest entry: " + entry + ".  Please validate your configuration.");
		}

		return retVal;
	}

	protected String createBuildIdentifierHash() {
		String buildIdentifier;
		try {
			buildIdentifier = getManifestEntry(MANIFEST_IMPLEMENTATION_VERSION) + getManifestEntry(MANIFEST_IMPLEMENTATION_BUILD);
		} catch (PropertyNotFoundException ex) {
			//log.warn("Unable to find build identifier, will default to runtime date {}", ex.getMessage(), ex);
			buildIdentifier = new Date().toString();
		}

		String hash;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(buildIdentifier.getBytes(Charset.forName("UTF8")));
			hash = Hex.encodeHexString(md.digest());
		} catch (NoSuchAlgorithmException ex) {
			hash = BAD_HASH;
		}

		return hash;
	}

	public String getBuildIdentifierHash() {
		if (this.buildIdentifierHash == null) {
			this.buildIdentifierHash = createBuildIdentifierHash();
		}
		return this.buildIdentifierHash;
	}

	public String getManifestImplementationVersion() {
		try {
			return getManifestEntry(MANIFEST_IMPLEMENTATION_VERSION);
		} catch (PropertyNotFoundException e) {
			return null;
		}
	}

	public String getBuildTime() {
		try {
			return getManifestEntry(MANIFEST_BUILD_TIME);
		} catch (PropertyNotFoundException e) {
			return null;
		}
	}

	public String getPackage() {
		try {
			return getManifestEntry(MANIFEST_PACKAGE);
		} catch (PropertyNotFoundException e) {
			return null;
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
