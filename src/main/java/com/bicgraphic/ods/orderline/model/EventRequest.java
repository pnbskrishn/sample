
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

/**
 * OrderLine Event Request from source system describing the kind of event and
 * the OrderLine data being edited
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "EventObject", "EventType", "EventDateTime", "EventSourceSystem", "EventBusinessID", "OrderLine" })
public class EventRequest {

	/**
	 * The type of event object being transmitted from source system (Required)
	 * 
	 */
	@JsonProperty("EventObject")
	@JsonPropertyDescription("")
	@NotNull
	private String eventObject;
	/**
	 * The type of event data being transmitted from source system. Create / Update
	 * /Delete (Required)
	 * 
	 */
	@JsonProperty("EventType")
	@JsonPropertyDescription("")
	@NotNull
	private EventRequest.EventType eventType;
	/**
	 * The date and time at which the even occurred in the source system (Required)
	 * 
	 */
	@JsonProperty("EventDateTime")
	@JsonPropertyDescription("")
	@NotNull
	private String eventDateTime;
	/**
	 * The source system at which the event occured (Required)
	 * 
	 */
	@JsonProperty("EventSourceSystem")
	@JsonPropertyDescription("")
	@NotNull
	private String eventSourceSystem;
	/**
	 * Business event ID for which the data is being transmitted in the current
	 * event (Required)
	 * 
	 */
	@JsonProperty("EventBusinessID")
	@JsonPropertyDescription("")
	@NotNull
	private String eventBusinessID;
	/**
	 * The OrderLine Data model /Schema to ODS
	 * <p>
	 * This object identifies the fields required to describe OrderLine object to
	 * ODS (Required)
	 * 
	 */
	@JsonProperty("OrderLine")
	@JsonPropertyDescription("")
	@Valid
	@NotNull
	private OrderLine orderLine;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * The type of event object being transmitted from source system (Required)
	 * 
	 * @return The eventObject
	 */
	@JsonProperty("EventObject")
	public String getEventObject() {
		return eventObject;
	}

	/**
	 * The type of event object being transmitted from source system (Required)
	 * 
	 * @param eventObject The EventObject
	 */
	@JsonProperty("EventObject")
	public void setEventObject(String eventObject) {
		this.eventObject = eventObject;
	}

	/**
	 * The type of event data being transmitted from source system. Create / Update
	 * /Delete (Required)
	 * 
	 * @return The eventType
	 */
	@JsonProperty("EventType")
	public EventRequest.EventType getEventType() {
		return eventType;
	}

	/**
	 * The type of event data being transmitted from source system. Create / Update
	 * /Delete (Required)
	 * 
	 * @param eventType The EventType
	 */
	@JsonProperty("EventType")
	public void setEventType(EventRequest.EventType eventType) {
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
	 * The source system at which the event occured (Required)
	 * 
	 * @return The eventSourceSystem
	 */
	@JsonProperty("EventSourceSystem")
	public String getEventSourceSystem() {
		return eventSourceSystem;
	}

	/**
	 * The source system at which the event occured (Required)
	 * 
	 * @param eventSourceSystem The EventSourceSystem
	 */
	@JsonProperty("EventSourceSystem")
	public void setEventSourceSystem(String eventSourceSystem) {
		this.eventSourceSystem = eventSourceSystem;
	}

	/**
	 * Business event ID for which the data is being transmitted in the current
	 * event (Required)
	 * 
	 * @return The eventBusinessID
	 */
	@JsonProperty("EventBusinessID")
	public String getEventBusinessID() {
		return eventBusinessID;
	}

	/**
	 * Business event ID for which the data is being transmitted in the current
	 * event (Required)
	 * 
	 * @param eventBusinessID The EventBusinessID
	 */
	@JsonProperty("EventBusinessID")
	public void setEventBusinessID(String eventBusinessID) {
		this.eventBusinessID = eventBusinessID;
	}

	/**
	 * The OrderLine Data model /Schema to ODS
	 * <p>
	 * This object identifies the fields required to describe OrderLine object to
	 * ODS (Required)
	 * 
	 * @return The orderLine
	 */
	@JsonProperty("OrderLine")
	public OrderLine getOrderLine() {
		return orderLine;
	}

	/**
	 * The OrderLine Data model /Schema to ODS
	 * <p>
	 * This object identifies the fields required to describe OrderLine object to
	 * ODS (Required)
	 * 
	 * @param orderLine The OrderLine
	 */
	@JsonProperty("OrderLine")
	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
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
				.append(eventSourceSystem).append(eventBusinessID).append(orderLine).append(additionalProperties)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof EventRequest) == false) {
			return false;
		}
		EventRequest rhs = ((EventRequest) other);
		return new EqualsBuilder().append(eventObject, rhs.eventObject).append(eventType, rhs.eventType)
				.append(eventDateTime, rhs.eventDateTime).append(eventSourceSystem, rhs.eventSourceSystem)
				.append(eventBusinessID, rhs.eventBusinessID).append(orderLine, rhs.orderLine)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

	public enum EventType {

		CREATE("CREATE"), UPDATE("UPDATE"), DELETE("DELETE");
		private final String value;
		private final static Map<String, EventRequest.EventType> CONSTANTS = new HashMap<String, EventRequest.EventType>();

		static {
			for (EventRequest.EventType c : values()) {
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
		public static EventRequest.EventType fromValue(String value) {
			EventRequest.EventType constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new IllegalArgumentException(value);
			} else {
				return constant;
			}
		}

	}

}
