
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Event Request Schema
 * <p>
 * This Schema defines the event request for pull requests from ODS for object
 * change identification and transmission
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "EventRequest" })
public class OrderlinePullEventDMRequest {

	/**
	 * Event Request from consumer systems describing the kind of event and data to
	 * be retreived (Required)
	 * 
	 */
	@JsonProperty("EventRequest")
	@JsonPropertyDescription("")
	@Valid
	@NotNull(message = "{validation.eventRequest.notNull}")
	private EventRequest_ eventRequest;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Event Request from consumer systems describing the kind of event and data to
	 * be retreived (Required)
	 * 
	 * @return The eventRequest
	 */
	@JsonProperty("EventRequest")
	public EventRequest_ getEventRequest() {
		return eventRequest;
	}

	/**
	 * Event Request from consumer systems describing the kind of event and data to
	 * be retreived (Required)
	 * 
	 * @param eventRequest The EventRequest
	 */
	@JsonProperty("EventRequest")
	public void setEventRequest(EventRequest_ eventRequest) {
		this.eventRequest = eventRequest;
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
		return new HashCodeBuilder().append(eventRequest).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof OrderlinePullEventDMRequest) == false) {
			return false;
		}
		OrderlinePullEventDMRequest rhs = ((OrderlinePullEventDMRequest) other);
		return new EqualsBuilder().append(eventRequest, rhs.eventRequest)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}
