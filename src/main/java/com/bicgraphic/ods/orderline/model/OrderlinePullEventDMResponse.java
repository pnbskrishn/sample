
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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ODS Event Response Schema
 * <p>
 * This Schema defines the event data repsonse from ODS to any and all incoming
 * event data from source systems
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "EventResponse" })
public class OrderlinePullEventDMResponse {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("EventResponse")
	@Valid
	@NotNull
	private EventResponse_ eventResponse;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * (Required)
	 * 
	 * @return The eventResponse
	 */
	@JsonProperty("EventResponse")
	public EventResponse_ getEventResponse() {
		return eventResponse;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param eventResponse The EventResponse
	 */
	@JsonProperty("EventResponse")
	public void setEventResponse(EventResponse_ eventResponse) {
		this.eventResponse = eventResponse;
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
		return new HashCodeBuilder().append(eventResponse).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof OrderlinePullEventDMResponse) == false) {
			return false;
		}
		OrderlinePullEventDMResponse rhs = ((OrderlinePullEventDMResponse) other);
		return new EqualsBuilder().append(eventResponse, rhs.eventResponse)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}
