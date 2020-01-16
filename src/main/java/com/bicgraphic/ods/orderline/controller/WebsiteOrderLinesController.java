/**
 * 
 */
package com.bicgraphic.ods.orderline.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bicgraphic.ods.orderline.commons.APIInfo;
import com.bicgraphic.ods.orderline.commons.ApplicationUtilities;
import com.bicgraphic.ods.orderline.commons.OdsConstants;
import com.bicgraphic.ods.orderline.exceptions.OrderLineException;
import com.bicgraphic.ods.orderline.model.EventRequest_;
import com.bicgraphic.ods.orderline.model.OrderLines;
import com.bicgraphic.ods.orderline.model.OrderlinePullEventDMRequest;
import com.bicgraphic.ods.orderline.model.OrderlinePullEventDMResponse;
import com.bicgraphic.ods.orderline.model.Status;
import com.bicgraphic.ods.orderline.service.OrderLinesService;
import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * @author dhanunjaya.potteti
 *
 */
@RestController
@RequestMapping("/orderlines")
public class WebsiteOrderLinesController {

	private static final Logger logger = LoggerFactory.getLogger(WebsiteOrderLinesController.class);

	@Autowired
	private ApplicationUtilities applicationUtilities;
	@Autowired
	private OrderLinesService orderLineService;
	@Autowired
	BuildProperties buildProperties;

	/*
	 * it will pull the all order lines based on Event request "Key value"
	 * 
	 * @param EventRequest
	 * 
	 */
	@RequestMapping(value = "/pullWebsiteOrderLines", consumes = {
			"application/json" }, produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<OrderlinePullEventDMResponse> pullWebsiteOrderLines(
			@Valid @RequestBody OrderlinePullEventDMRequest orderlinePullEventDMRequest) {
		OrderlinePullEventDMResponse orderLinePullEventDMResponse = new OrderlinePullEventDMResponse();
		boolean validationflag = false;
		EventRequest_ eventRequest = orderlinePullEventDMRequest.getEventRequest();
		List<String> reportList = new ArrayList<String>();

		try {

			validationflag = applicationUtilities.validatePullRequest(eventRequest, reportList);

			if (!validationflag) {
				OrderLines orderlines = orderLineService
						.getOrderLines(eventRequest.getRequestRecords().getRequestRecord());
				if (orderlines.getOrderLine().isEmpty()) {
					orderLinePullEventDMResponse = applicationUtilities.prepareCommonResponse(
							OdsConstants.ORDERLINE_DATA_NOT_FOUND_CODE, OdsConstants.ORDERLINE_DATA_NOT_FOUND_MSG,
							eventRequest, orderLinePullEventDMResponse);

				} else {

					orderLinePullEventDMResponse = applicationUtilities.prepareCommonResponse(eventRequest,
							orderLinePullEventDMResponse, orderlines);
				}
			} else {
				throw new OrderLineException(OdsConstants.ORDERLINE_INV_INPUT_CODE, String.join(",", reportList));

			}
		} catch (OrderLineException exception) {

			orderLinePullEventDMResponse = applicationUtilities.prepareCommonResponse(exception.getOrderLineResCode(),
					exception.getOrderLineResMsg(), eventRequest, orderLinePullEventDMResponse);
		} catch (Exception e) {
			logger.error(e.getMessage());
			orderLinePullEventDMResponse = applicationUtilities.prepareCommonResponse(
					OdsConstants.ORDERLINE_UNKNOWN_ERR_CODE, OdsConstants.ORDERLINE_UNKNOWN_ERR_MSG, eventRequest,
					orderLinePullEventDMResponse);
		}
		return new ResponseEntity<>(orderLinePullEventDMResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/version", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<Object> getVersion() throws Exception {
		APIInfo apiInfo = new APIInfo();
		apiInfo.setBuildNumber(buildProperties.getVersion());
		return new ResponseEntity<Object>(apiInfo, HttpStatus.OK);
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/diagnostics", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<Object> getDiagnostics() throws Exception {
		APIInfo apiInfo = new APIInfo();
		StringBuilder sb = new StringBuilder();
		Properties prop = new Properties();
		InputStream input = null;
		try {
			ClassLoader cl = this.getClass().getClassLoader();
			// Getting the DB config from Properties file and checking the connection
			input = cl.getResourceAsStream("integration_mongo.properties");
			prop.load(input);
			String hostName = prop.getProperty("mongo.hostname");
			String port = prop.getProperty("mongo.port");
			Mongo m = new Mongo(hostName, Integer.parseInt(port));
			input = cl.getResourceAsStream("application.properties");
			prop.load(input);
			DB db = m.getDB(prop.getProperty("odsorderline.dbname"));
			sb.append("MongoDB Connection Good. ");
			sb.append("Application.properties File available.");
			apiInfo.setMessage(sb.toString());

		} catch (Exception ex) {
			return new ResponseEntity<Object>(
					new Status(OdsConstants.ORDERLINE_UNKNOWN_ERR_CODE, OdsConstants.ORDERLINE_UNKNOWN_ERR_MSG),
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(apiInfo, HttpStatus.OK);
	}

	public ResponseEntity<String> handleValidationFailure() {
		// waiting for business logic
		return null;

	}
}
