
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
 * OrderLine Data Model Schema
 * <p>
 * This Schema defines the OrderLine data in ODS
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "OrderLineData" })
public class ODSOrderlineCanonical {

	/**
	 * This object identifies the fields required to describe OrderLine object in
	 * ODS (Required)
	 * 
	 */
	@JsonProperty("OrderLineData")
	@JsonPropertyDescription("")
	@Valid
	@NotNull
	private OrderLineData orderLineData;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * This object identifies the fields required to describe OrderLine object in
	 * ODS (Required)
	 * 
	 * @return The orderLineData
	 */
	@JsonProperty("OrderLineData")
	public OrderLineData getOrderLineData() {
		return orderLineData;
	}

	/**
	 * This object identifies the fields required to describe OrderLine object in
	 * ODS (Required)
	 * 
	 * @param orderLineData The OrderLineData
	 */
	@JsonProperty("OrderLineData")
	public void setOrderLineData(OrderLineData orderLineData) {
		this.orderLineData = orderLineData;
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
		return new HashCodeBuilder().append(orderLineData).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ODSOrderlineCanonical) == false) {
			return false;
		}
		ODSOrderlineCanonical rhs = ((ODSOrderlineCanonical) other);
		return new EqualsBuilder().append(orderLineData, rhs.orderLineData)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}
