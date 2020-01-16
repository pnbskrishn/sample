
package com.bicgraphic.ods.orderline.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
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
@JsonPropertyOrder({ "EnterpriseEventID", "EventBusinessID", "EventStatus", "MustRetryFlag", "EventErrorCode",
		"EventStatusMessage", "OrderLines" })
public class EventResponse_ {

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
	private EventResponse_.EventStatus eventStatus;
	/**
	 * This flag indicates if the event needs to be retried from the source system
	 * in case of any error. (Required)
	 * 
	 */
	@JsonProperty("MustRetryFlag")
	@JsonPropertyDescription("")
	@NotNull
	private Boolean mustRetryFlag;
	/**
	 * The unique error code identifying Business and System Faults to consumers
	 * (Required)
	 * 
	 */
	@JsonProperty("EventErrorCode")
	@JsonPropertyDescription("")
	@NotNull
	private String eventErrorCode;
	/**
	 * Any pertaining event message that may be needed for the source system. This
	 * will be used mostly to describe any error message or description from ODS.
	 * (Required)
	 * 
	 */
	@JsonProperty("EventStatusMessage")
	@JsonPropertyDescription("")
	@NotNull
	private String eventStatusMessage;
	/**
	 * 
	 */
	@JsonProperty("OrderLines")
	@Valid
	private OrderLines orderLines;
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
	public EventResponse_.EventStatus getEventStatus() {
		return eventStatus;
	}

	/**
	 * The status of the event request within ODS (Required)
	 * 
	 * @param eventStatus The EventStatus
	 */
	@JsonProperty("EventStatus")
	public void setEventStatus(EventResponse_.EventStatus eventStatus) {
		this.eventStatus = eventStatus;
	}

	/**
	 * This flag indicates if the event needs to be retried from the source system
	 * in case of any error. (Required)
	 * 
	 * @return The mustRetryFlag
	 */
	@JsonProperty("MustRetryFlag")
	public Boolean getMustRetryFlag() {
		return mustRetryFlag;
	}

	/**
	 * This flag indicates if the event needs to be retried from the source system
	 * in case of any error. (Required)
	 * 
	 * @param mustRetryFlag The MustRetryFlag
	 */
	@JsonProperty("MustRetryFlag")
	public void setMustRetryFlag(Boolean mustRetryFlag) {
		this.mustRetryFlag = mustRetryFlag;
	}

	/**
	 * The unique error code identifying Business and System Faults to consumers
	 * (Required)
	 * 
	 * @return The eventErrorCode
	 */
	@JsonProperty("EventErrorCode")
	public String getEventErrorCode() {
		return eventErrorCode;
	}

	/**
	 * The unique error code identifying Business and System Faults to consumers
	 * (Required)
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
	 * (Required)
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
	 * (Required)
	 * 
	 * @param eventStatusMessage The EventStatusMessage
	 */
	@JsonProperty("EventStatusMessage")
	public void setEventStatusMessage(String eventStatusMessage) {
		this.eventStatusMessage = eventStatusMessage;
	}

	/**
	 * 
	 * @return The orderLines
	 */
	@JsonProperty("OrderLines")
	public OrderLines getOrderLines() {
		return orderLines;
	}

	/**
	 * 
	 * @param orderLines The OrderLines
	 */
	@JsonProperty("OrderLines")
	public void setOrderLines(OrderLines orderLines) {
		this.orderLines = orderLines;
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
				.append(mustRetryFlag).append(eventErrorCode).append(eventStatusMessage).append(orderLines)
				.append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof EventResponse_) == false) {
			return false;
		}
		EventResponse_ rhs = ((EventResponse_) other);
		return new EqualsBuilder().append(enterpriseEventID, rhs.enterpriseEventID)
				.append(eventBusinessID, rhs.eventBusinessID).append(eventStatus, rhs.eventStatus)
				.append(mustRetryFlag, rhs.mustRetryFlag).append(eventErrorCode, rhs.eventErrorCode)
				.append(eventStatusMessage, rhs.eventStatusMessage).append(orderLines, rhs.orderLines)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

	public enum EventStatus {

		SUCCESS("SUCCESS"), ERROR("ERROR");
		private final String value;
		private final static Map<String, EventResponse_.EventStatus> CONSTANTS = new HashMap<String, EventResponse_.EventStatus>();

		static {
			for (EventResponse_.EventStatus c : values()) {
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
		public static EventResponse_.EventStatus fromValue(String value) {
			EventResponse_.EventStatus constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new IllegalArgumentException(value);
			} else {
				return constant;
			}
		}

	}

}
