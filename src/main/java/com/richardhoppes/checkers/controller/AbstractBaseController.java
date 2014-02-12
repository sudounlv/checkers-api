package com.richardhoppes.checkers.controller;

import com.richardhoppes.checkers.common.AppInfo;
import com.richardhoppes.checkers.common.Settings;
import com.richardhoppes.checkers.exception.PropertyNotFoundException;
import com.richardhoppes.checkers.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Settings settings;

	@Autowired
	AppInfo appInfo;

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public @ResponseBody Map<String, String> handleException(ResourceNotFoundException ex) {
		return createStandardErrorResponse(ex.getMessage(), ex.getErrorCode(), HttpStatus.NOT_FOUND);
	}

	private Map<String, String> createStandardErrorResponse(String message, String errorCode, HttpStatus httpStatus) {
		Map<String, String> retVal = new HashMap<String, String>();
		retVal.put("error_message", message);
		retVal.put("error_code", errorCode);
		retVal.put("status_code", httpStatus.toString());
		retVal.put("status_message", httpStatus.getReasonPhrase());
		return retVal;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		try {
			String dateFormatString = settings.getDateFormatString();
			SimpleDateFormat formatter = new SimpleDateFormat(dateFormatString);
			formatter.setLenient(true);
			dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(formatter, false));
		} catch (PropertyNotFoundException e) {
			log.error("Unable to set dateFormatString: {}", e);
		}
	 }

}
