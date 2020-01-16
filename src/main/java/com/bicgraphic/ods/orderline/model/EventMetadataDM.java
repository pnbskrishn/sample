
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
 * Event Metadata Schema
 * <p>
 * This Schema defines the event metadata for use within ODS for Event
 * identification and transmission
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "EventMetadata" })
public class EventMetadataDM {

	/**
	 * Orderline Event Request from source system describing the kind of event and
	 * the Orderline data being edited (Required)
	 * 
	 */
	@JsonProperty("EventMetadata")
	@JsonPropertyDescription("")
	@Valid
	@NotNull
	private EventMetadata eventMetadata;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Orderline Event Request from source system describing the kind of event and
	 * the Orderline data being edited (Required)
	 * 
	 * @return The eventMetadata
	 */
	@JsonProperty("EventMetadata")
	public EventMetadata getEventMetadata() {
		return eventMetadata;
	}

	/**
	 * Orderline Event Request from source system describing the kind of event and
	 * the Orderline data being edited (Required)
	 * 
	 * @param eventMetadata The EventMetadata
	 */
	@JsonProperty("EventMetadata")
	public void setEventMetadata(EventMetadata eventMetadata) {
		this.eventMetadata = eventMetadata;
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
		return new HashCodeBuilder().append(eventMetadata).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof EventMetadataDM) == false) {
			return false;
		}
		EventMetadataDM rhs = ((EventMetadataDM) other);
		return new EqualsBuilder().append(eventMetadata, rhs.eventMetadata)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}
