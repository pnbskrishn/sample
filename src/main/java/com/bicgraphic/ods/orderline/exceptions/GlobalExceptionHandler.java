package com.bicgraphic.ods.orderline.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bicgraphic.ods.orderline.commons.OdsConstants;
import com.bicgraphic.ods.orderline.model.EventDMResponse;
import com.bicgraphic.ods.orderline.model.EventResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	OdsConstants odsConstants;
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<EventDMResponse> genericExceptionHandler(Exception exception) {
		LOGGER.error("Exception Triggered:#{}", exception.getMessage());

		EventResponse eventResponse = new EventResponse();
		EventDMResponse eventDMResponse = new EventDMResponse();
		eventResponse.setEventStatus(eventResponse.getEventStatus().valueOf("ERROR"));
		eventResponse.setEventErrorCode(OdsConstants.ORDERLINE_UNKNOWN_ERR_CODE);
		eventResponse.setMustRetryFlag("true");
		eventResponse.setEventStatusMessage(OdsConstants.ORDERLINE_UNKNOWN_ERR_MSG);
		eventDMResponse.setEventResponse(eventResponse);

		return new ResponseEntity<EventDMResponse>(eventDMResponse, HttpStatus.OK);
	}

	@ExceptionHandler(value = OrderLineException.class)
	public ResponseEntity<EventDMResponse> ExceptionHandler(OrderLineException exception) {
		LOGGER.error("Exception Triggered:#{}", exception.getMessage());

		EventResponse eventResponse = new EventResponse();
		EventDMResponse eventDMResponse = new EventDMResponse();
		eventResponse.setEventStatus(eventResponse.getEventStatus().valueOf("ERROR"));
		eventResponse.setEventErrorCode(exception.getOrderLineResCode());
		eventResponse.setMustRetryFlag("true");
		eventResponse.setEventStatusMessage(exception.getOrderLineResMsg());
		eventDMResponse.setEventResponse(eventResponse);

		return new ResponseEntity<EventDMResponse>(eventDMResponse, HttpStatus.OK);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		List<String> validationErrorList = new ArrayList<String>();
		for (FieldError error : errors) {
			validationErrorList.add(error.getDefaultMessage());
		}
		EventResponse eventResponse = new EventResponse();
		EventDMResponse eventDMResponse = new EventDMResponse();
		eventResponse.setEventStatus(eventResponse.getEventStatus().valueOf("ERROR"));
		eventResponse.setEventErrorCode(OdsConstants.ORDERLINE_INV_INPUT_CODE);
		eventResponse.setEventStatusMessage(validationErrorList.toString());
		eventResponse.setMustRetryFlag("true");
		eventDMResponse.setEventResponse(eventResponse);
		return new ResponseEntity<>(eventDMResponse, HttpStatus.OK);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		EventResponse eventResponse = new EventResponse();
		EventDMResponse eventDMResponse = new EventDMResponse();
		eventResponse.setEventStatus(eventResponse.getEventStatus().valueOf("ERROR"));
		eventResponse.setEventErrorCode(OdsConstants.ORDERLINE_INV_INPUT_CODE);
		eventResponse.setMustRetryFlag("true");
		eventResponse.setEventStatusMessage("invalid structure check with values ex:Event Type");
		eventDMResponse.setEventResponse(eventResponse);
		return new ResponseEntity<>(eventDMResponse, HttpStatus.OK);
	}
}
