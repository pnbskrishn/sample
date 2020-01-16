
package com.bicgraphic.ods.orderline.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import com.bicgraphic.ods.orderline.commons.OdsConstants;
import com.bicgraphic.ods.orderline.exceptions.OrderLineException;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Event Request from consumer systems describing the kind of event and data to
 * be retreived
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "EventObject", "EventType", "EventDateTime", "EventRequestSystem", "EventSystemOfTruth",
		"EventBusinessID", "RequestRecords" })
public class EventRequest_ {

	/**
	 * The type of event object expected from ODS (Required)
	 * 
	 */
	@JsonProperty("EventObject")
	@JsonPropertyDescription("")
	@NotBlank(message = "{validation.eventObject.notNull}")
	private String eventObject;
	/**
	 * The type of event request from ODS (Required)
	 * 
	 */
	@JsonProperty("EventType")
	@JsonPropertyDescription("")
	@NotNull(message = "{validation.eventType.notNull}")
	private EventRequest_.EventType eventType;
	/**
	 * The date and time at which the even occurred in the source system (Required)
	 * 
	 */
	@JsonProperty("EventDateTime")
	@JsonPropertyDescription("")
	@NotBlank(message = "{validation.eventDateTime.notNull}")
	private String eventDateTime;
	/**
	 * The system requesting the event data
	 * 
	 */
	@JsonProperty("EventRequestSystem")
	@JsonPropertyDescription("")
	private String eventRequestSystem;
	/**
	 * The system of truth at which the event occured
	 * 
	 */
	@JsonProperty("EventSystemOfTruth")
	@JsonPropertyDescription("")
	private String eventSystemOfTruth;
	/**
	 * Business event ID for which the data is being transmitted in the current
	 * event
	 * 
	 */
	@JsonProperty("EventBusinessID")
	@JsonPropertyDescription("")
	@NotBlank(message = "{validation.EventBusinessID.notNull}")
	private String eventBusinessID;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("RequestRecords")
	@Valid
	@NotNull(message = "{validation.requestRecord.notNull}")
	private RequestRecords requestRecords;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * The type of event object expected from ODS (Required)
	 * 
	 * @return The eventObject
	 */
	@JsonProperty("EventObject")
	public String getEventObject() {
		return eventObject;
	}

	/**
	 * The type of event object expected from ODS (Required)
	 * 
	 * @param eventObject The EventObject
	 */
	@JsonProperty("EventObject")
	public void setEventObject(String eventObject) {
		this.eventObject = eventObject;
	}

	/**
	 * The type of event request from ODS (Required)
	 * 
	 * @return The eventType
	 */
	@JsonProperty("EventType")
	public EventRequest_.EventType getEventType() {
		return eventType;
	}

	/**
	 * The type of event request from ODS (Required)
	 * 
	 * @param eventType The EventType
	 */
	@JsonProperty("EventType")
	public void setEventType(EventRequest_.EventType eventType) {
		this.eventType = eventType;
	}

	/**
	 * The date and time at which the even occurred in the source system (Required)
	 * 
	 * @return The eventDateTime
	 */
	@JsonProperty("EventDateTime")
	public String getEventDateTime() {
		return eventDateTime;
	}

	/**
	 * The date and time at which the even occurred in the source system (Required)
	 * 
	 * @param eventDateTime The EventDateTime
	 */
	@JsonProperty("EventDateTime")
	public void setEventDateTime(String eventDateTime) {
		this.eventDateTime = eventDateTime;
	}

	/**
	 * The system requesting the event data
	 * 
	 * @return The eventRequestSystem
	 */
	@JsonProperty("EventRequestSystem")
	public String getEventRequestSystem() {
		return eventRequestSystem;
	}

	/**
	 * The system requesting the event data
	 * 
	 * @param eventRequestSystem The EventRequestSystem
	 */
	@JsonProperty("EventRequestSystem")
	public void setEventRequestSystem(String eventRequestSystem) {
		this.eventRequestSystem = eventRequestSystem;
	}

	/**
	 * The system of truth at which the event occured
	 * 
	 * @return The eventSystemOfTruth
	 */
	@JsonProperty("EventSystemOfTruth")
	public String getEventSystemOfTruth() {
		return eventSystemOfTruth;
	}

	/**
	 * The system of truth at which the event occured
	 * 
	 * @param eventSystemOfTruth The EventSystemOfTruth
	 */
	@JsonProperty("EventSystemOfTruth")
	public void setEventSystemOfTruth(String eventSystemOfTruth) {
		this.eventSystemOfTruth = eventSystemOfTruth;
	}

	/**
	 * Business event ID for which the data is being transmitted in the current
	 * event
	 * 
	 * @return The eventBusinessID
	 */
	@JsonProperty("EventBusinessID")
	public String getEventBusinessID() {
		return eventBusinessID;
	}

	/**
	 * Business event ID for which the data is being transmitted in the current
	 * event
	 * 
	 * @param eventBusinessID The EventBusinessID
	 */
	@JsonProperty("EventBusinessID")
	public void setEventBusinessID(String eventBusinessID) {
		this.eventBusinessID = eventBusinessID;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The requestRecords
	 */
	@JsonProperty("RequestRecords")
	public RequestRecords getRequestRecords() {
		return requestRecords;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param requestRecords The RequestRecords
	 */
	@JsonProperty("RequestRecords")
	public void setRequestRecords(RequestRecords requestRecords) {
		this.requestRecords = requestRecords;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(eventObject).append(eventType).append(eventDateTime)
				.append(eventRequestSystem).append(eventSystemOfTruth).append(eventBusinessID).append(requestRecords)
				.append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof EventRequest_) == false) {
			return false;
		}
		EventRequest_ rhs = ((EventRequest_) other);
		return new EqualsBuilder().append(eventObject, rhs.eventObject).append(eventType, rhs.eventType)
				.append(eventDateTime, rhs.eventDateTime).append(eventRequestSystem, rhs.eventRequestSystem)
				.append(eventSystemOfTruth, rhs.eventSystemOfTruth).append(eventBusinessID, rhs.eventBusinessID)
				.append(requestRecords, rhs.requestRecords).append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

	public enum EventType {

		PULL_REQUEST("PULL_REQUEST");
		private final String value;
		private final static Map<String, EventRequest_.EventType> CONSTANTS = new HashMap<String, EventRequest_.EventType>();

		static {
			for (EventRequest_.EventType c : values()) {
				CONSTANTS.put(c.value, c);
			}
		}

		private EventType(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}

		@JsonValue
		public String value() {
			return this.value;
		}

		@JsonCreator
		public static EventRequest_.EventType fromValue(String value) {
			EventRequest_.EventType constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new OrderLineException(OdsConstants.ORDERLINE_INV_INPUT_CODE,
						"EvemtType value should be PULL_REQUEST");
			} else {
				return constant;
			}
		}

	}

}
