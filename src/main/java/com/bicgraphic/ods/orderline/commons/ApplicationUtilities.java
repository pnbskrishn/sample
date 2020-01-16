/**
 * 
 */
package com.bicgraphic.ods.orderline.commons;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bicgraphic.ods.orderline.exceptions.OrderLineException;
import com.bicgraphic.ods.orderline.model.EventRequest_;
import com.bicgraphic.ods.orderline.model.EventResponse_;
import com.bicgraphic.ods.orderline.model.OrderLines;
import com.bicgraphic.ods.orderline.model.OrderlinePullEventDMResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author dhanunjaya.potteti
 *
 */
@Component
public class ApplicationUtilities {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationUtilities.class);

	/*
	 * @param reqJson This parameter contains Request in json format
	 * 
	 * @param clazz This parameter represents our bean class type
	 * 
	 * @return T This returns our param class type object with request values.
	 */
	public <T> T convertTypeReference(String reqJson, Class<T> clazz) {
		try {
			return new ObjectMapper().readValue(reqJson, clazz);
		} catch (Exception exception) {
			logger.error("Error : while convertion request to bean class#{}", exception.getMessage());
			throw new OrderLineException(OdsConstants.ORDERLINE_INV_INPUT_CODE, OdsConstants.ORDERLINE_INV_INPUT_MSG);
		}

	}

	public OrderlinePullEventDMResponse prepareCommonResponse(EventRequest_ eventRequest,
			OrderlinePullEventDMResponse orderlinePullResponse, OrderLines orderlines) {
		EventResponse_ eventResponse = new EventResponse_();
		eventResponse.setEnterpriseEventID(eventRequest.getEventBusinessID());
		eventResponse.setEventBusinessID(eventRequest.getEventBusinessID());
		eventResponse.setEventStatus(eventResponse.getEventStatus().SUCCESS);
		eventResponse.setEventStatusMessage("");
		eventResponse.setMustRetryFlag(false);
		eventResponse.setOrderLines(orderlines);
		orderlinePullResponse.setEventResponse(eventResponse);
		return orderlinePullResponse;
	}

	public OrderlinePullEventDMResponse prepareCommonResponse(String errorCode, String statusMsg,
			EventRequest_ eventRequest, OrderlinePullEventDMResponse orderlinePullResponse) {
		EventResponse_ eventResponse = new EventResponse_();
		eventResponse.setEnterpriseEventID(eventRequest.getEventBusinessID());
		eventResponse.setEventBusinessID(eventRequest.getEventBusinessID());
		eventResponse.setEventStatus(eventResponse.getEventStatus().ERROR);
		eventResponse.setEventErrorCode(errorCode);
		eventResponse.setEventStatusMessage(statusMsg);
		eventResponse.setMustRetryFlag(true);

		orderlinePullResponse.setEventResponse(eventResponse);
		return orderlinePullResponse;
	}

	public boolean validatePullRequest(EventRequest_ eventRequest, List<String> reportList) {
		boolean validationflag = false;
		if (!eventRequest.getEventType().value().equals("PULL_REQUEST")
				|| null == eventRequest.getEventType().values()) {
			validationflag = true;
			reportList.add("EventType value Should be PULL_REQUEST  and mandatory");
		}
		if (!eventRequest.getEventObject().equals("ORDERLINE") || eventRequest.getEventObject().equals(null)) {
			validationflag = true;
			reportList.add("EventObject value Should be ORDERLINE and mandatory");
		}
		return validationflag;
	}

}
