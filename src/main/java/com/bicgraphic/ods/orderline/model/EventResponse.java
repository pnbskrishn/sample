package com.bicgraphic.ods.orderline.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "EnterpriseEventID", "EventBusinessID", "EventStatus", "EventErrorCode", "EventStatusMessage",
		"MustRetryFlag" })
public class EventResponse {

	/**
	 * The Unique Event ID generated in ODS for the current event request from
	 * Source system (Required)
	 * 
	 */
	@JsonProperty("EnterpriseEventID")
	@JsonPropertyDescription("")
	@NotNull
	private String enterpriseEventID;
	/**
	 * The business ID provided by the Source system in the Event request (Required)
	 * 
	 */
	@JsonProperty("EventBusinessID")
	@JsonPropertyDescription("")
	@NotNull
	private String eventBusinessID;
	/**
	 * The status of the event request within ODS (Required)
	 * 
	 */
	@JsonProperty("EventStatus")
	@JsonPropertyDescription("")
	@NotNull
	private EventResponse.EventStatus eventStatus;
	/**
	 * The unique error code identifying Business and System Faults to consumers
	 * 
	 */
	@JsonProperty("EventErrorCode")
	@JsonPropertyDescription("")
	private String eventErrorCode;
	/**
	 * Any pertaining event message that may be needed for the source system. This
	 * will be used mostly to describe any error message or description from ODS.
	 * 
	 */
	@JsonProperty("EventStatusMessage")
	@JsonPropertyDescription("")
	private String eventStatusMessage;
	/**
	 * This flag indicates if the event needs to be retried from the source system
	 * in case of any error. (Required)
	 * 
	 */
	@JsonProperty("MustRetryFlag")
	@JsonPropertyDescription("")
	@NotNull
	private String mustRetryFlag;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * The Unique Event ID generated in ODS for the current event request from
	 * Source system (Required)
	 * 
	 * @return The enterpriseEventID
	 */
	@JsonProperty("EnterpriseEventID")
	public String getEnterpriseEventID() {
		return enterpriseEventID;
	}

	/**
	 * The Unique Event ID generated in ODS for the current event request from
	 * Source system (Required)
	 * 
	 * @param enterpriseEventID The EnterpriseEventID
	 */
	@JsonProperty("EnterpriseEventID")
	public void setEnterpriseEventID(String enterpriseEventID) {
		this.enterpriseEventID = enterpriseEventID;
	}

	/**
	 * The business ID provided by the Source system in the Event request (Required)
	 * 
	 * @return The eventBusinessID
	 */
	@JsonProperty("EventBusinessID")
	public String getEventBusinessID() {
		return eventBusinessID;
	}

	/**
	 * The business ID provided by the Source system in the Event request (Required)
	 * 
	 * @param eventBusinessID The EventBusinessID
	 */
	@JsonProperty("EventBusinessID")
	public void setEventBusinessID(String eventBusinessID) {
		this.eventBusinessID = eventBusinessID;
	}

	/**
	 * The status of the event request within ODS (Required)
	 * 
	 * @return The eventStatus
	 */
	@JsonProperty("EventStatus")
	public EventResponse.EventStatus getEventStatus() {
		return eventStatus;
	}

	/**
	 * The status of the event request within ODS (Required)
	 * 
	 * @param eventStatus The EventStatus
	 */
	@JsonProperty("EventStatus")
	public void setEventStatus(EventResponse.EventStatus eventStatus) {
		this.eventStatus = eventStatus;
	}

	/**
	 * The unique error code identifying Business and System Faults to consumers
	 * 
	 * @return The eventErrorCode
	 */
	@JsonProperty("EventErrorCode")
	public String getEventErrorCode() {
		return eventErrorCode;
	}

	/**
	 * The unique error code identifying Business and System Faults to consumers
	 * 
	 * @param eventErrorCode The EventErrorCode
	 */
	@JsonProperty("EventErrorCode")
	public void setEventErrorCode(String eventErrorCode) {
		this.eventErrorCode = eventErrorCode;
	}

	/**
	 * Any pertaining event message that may be needed for the source system. This
	 * will be used mostly to describe any error message or description from ODS.
	 * 
	 * @return The eventStatusMessage
	 */
	@JsonProperty("EventStatusMessage")
	public String getEventStatusMessage() {
		return eventStatusMessage;
	}

	/**
	 * Any pertaining event message that may be needed for the source system. This
	 * will be used mostly to describe any error message or description from ODS.
	 * 
	 * @param eventStatusMessage The EventStatusMessage
	 */
	@JsonProperty("EventStatusMessage")
	public void setEventStatusMessage(String eventStatusMessage) {
		this.eventStatusMessage = eventStatusMessage;
	}

	/**
	 * This flag indicates if the event needs to be retried from the source system
	 * in case of any error. (Required)
	 * 
	 * @return The mustRetryFlag
	 */
	@JsonProperty("MustRetryFlag")
	public String getMustRetryFlag() {
		return mustRetryFlag;
	}

	/**
	 * This flag indicates if the event needs to be retried from the source system
	 * in case of any error. (Required)
	 * 
	 * @param mustRetryFlag The MustRetryFlag
	 */
	@JsonProperty("MustRetryFlag")
	public void setMustRetryFlag(String mustRetryFlag) {
		this.mustRetryFlag = mustRetryFlag;
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
		return new HashCodeBuilder().append(enterpriseEventID).append(eventBusinessID).append(eventStatus)
				.append(eventErrorCode).append(eventStatusMessage).append(mustRetryFlag).append(additionalProperties)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof EventResponse) == false) {
			return false;
		}
		EventResponse rhs = ((EventResponse) other);
		return new EqualsBuilder().append(enterpriseEventID, rhs.enterpriseEventID)
				.append(eventBusinessID, rhs.eventBusinessID).append(eventStatus, rhs.eventStatus)
				.append(eventErrorCode, rhs.eventErrorCode).append(eventStatusMessage, rhs.eventStatusMessage)
				.append(mustRetryFlag, rhs.mustRetryFlag).append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

	public enum EventStatus {

		SUCCESS("SUCCESS"), ERROR("ERROR");
		private final String value;
		private final static Map<String, EventResponse.EventStatus> CONSTANTS = new HashMap<String, EventResponse.EventStatus>();

		static {
			for (EventResponse.EventStatus c : values()) {
				CONSTANTS.put(c.value, c);
			}
		}

		private EventStatus(String value) {
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
		public static EventResponse.EventStatus fromValue(String value) {
			EventResponse.EventStatus constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new IllegalArgumentException(value);
			} else {
				return constant;
			}
		}

	}

}
