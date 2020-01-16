
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
 * OrderLine Event Schema
 * <p>
 * This Schema defines the OrderLine event data such as Create Update Delete for
 * data sync to ODS
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "EventRequest" })
public class OrderlineEventDMRequest {

	/**
	 * OrderLine Event Request from source system describing the kind of event and
	 * the OrderLine data being edited (Required)
	 * 
	 */
	@JsonProperty("EventRequest")
	@JsonPropertyDescription("")
	@Valid
	@NotNull
	private EventRequest eventRequest;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * OrderLine Event Request from source system describing the kind of event and
	 * the OrderLine data being edited (Required)
	 * 
	 * @return The eventRequest
	 */
	@JsonProperty("EventRequest")
	public EventRequest getEventRequest() {
		return eventRequest;
	}

	/**
	 * OrderLine Event Request from source system describing the kind of event and
	 * the OrderLine data being edited (Required)
	 * 
	 * @param eventRequest The EventRequest
	 */
	@JsonProperty("EventRequest")
	public void setEventRequest(EventRequest eventRequest) {
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
		if ((other instanceof OrderlineEventDMRequest) == false) {
			return false;
		}
		OrderlineEventDMRequest rhs = ((OrderlineEventDMRequest) other);
		return new EqualsBuilder().append(eventRequest, rhs.eventRequest)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}
