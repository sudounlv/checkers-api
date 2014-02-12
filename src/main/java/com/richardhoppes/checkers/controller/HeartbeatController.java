package com.richardhoppes.checkers.controller;

import com.richardhoppes.checkers.dao.GameDAO;
import com.richardhoppes.checkers.exception.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/heartbeat")
public class HeartbeatController extends AbstractBaseController{

	@Autowired
	GameDAO developerDAO;

	@RequestMapping(value="detail")
	public @ResponseBody Map<String, String> actionDetail() {
		Map<String, String> retVal = new HashMap<String, String>();

		try {
			retVal.put("mode", settings.getMode());
		} catch (PropertyNotFoundException e) {
			retVal.put("mode", "unknown");
		}

		retVal.put("status", "OK");
		retVal.put("package", appInfo.getPackage());
		retVal.put("version", appInfo.getManifestImplementationVersion());
		retVal.put("build_time", appInfo.getBuildTime());
		retVal.put("identifier_hash", appInfo.getBuildIdentifierHash());

		return retVal;
	}

	@RequestMapping(value="")
	public @ResponseBody Map<String, String> actionSimple() {
		Map<String, String> retVal = new HashMap<String, String>();
		retVal.put("status", "OK");

		return retVal;
	}
}
