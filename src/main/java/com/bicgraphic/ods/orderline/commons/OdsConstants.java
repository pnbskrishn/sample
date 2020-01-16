package com.bicgraphic.ods.orderline.commons;

import org.springframework.stereotype.Component;

@Component
public class OdsConstants {

	public static final String ORDERLINE_SUCCESS = "SUCCESS";
	// Response Codes
	public static final String ORDERLINE_INV_STRUCTURE_CODE = "INTERR-111";
	public static final String ORDERLINE_MANDATORY_MISS_CODE = "INTERR-112";
	public static final String ORDERLINE_INV_INPUT_CODE = "INTERR-113";
	public static final String ORDERLINE_DATA_NOT_FOUND_CODE = "INTERR-114";
	public static final String ORDERLINE_EVENT_NETWORK_ERR_CODE = "EVENT-ERR";
	public static final String ORDERLINE_UNKNOWN_ERR_CODE = "INTERR-115";
	public static final String ORDERLINE_SUCCESS_CODE = "INTERR-000";
	// Response Messages
	public static final String ORDERLINE_INV_STRUCTURE_MSG = "Invalid Data Structure in Request.";
	public static final String ORDERLINE_MANDATORY_MISS_MSG = "Mandatory request field missing.";
	public static final String ORDERLINE_INV_INPUT_MSG = "Incorrect request field value";
	public static final String ORDERLINE_DATA_NOT_FOUND_MSG = "No Records found for given input/KeyName value should be 'OrderNumber'";
	public static final String ORDERLINE_UNKNOWN_ERR_MSG = "OOPS! Something went wrong";
	public static final String ORDERLINE_SUCCESS_MSG = "Operation Succefully Completed";
}
