
package com.bicgraphic.ods.orderline.model;

import java.util.HashMap;
import java.util.Map;

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
 * This object identifies the fields required to describe OrderLine object in
 * ODS
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "OrderNumber", "OrderLineID", "LineNumber", "ProductNumber", "ProductName", "Uom", "OrderedQty",
		"ShippedQty", "LineStatus", "Price", "ShipMethod", "TrackingNumber", "ProofStatus", "HoldStatus", "ShipDate",
		"ImprintColor", "ImprintLocation" })
public class OrderLineData {

	/**
	 * The OrderNumber in the source system (Required)
	 * 
	 */
	@JsonProperty("OrderNumber")
	@JsonPropertyDescription("")
	@NotNull
	private String orderNumber;
	/**
	 * The OrderLine's ID in the source system (Required)
	 * 
	 */
	@JsonProperty("OrderLineID")
	@JsonPropertyDescription("")
	@NotNull
	private String orderLineID;
	/**
	 * The LineNumber in the source system (Required)
	 * 
	 */
	@JsonProperty("LineNumber")
	@JsonPropertyDescription("")
	@NotNull
	private String lineNumber;
	/**
	 * The ProductNumber in the source system
	 * 
	 */
	@JsonProperty("ProductNumber")
	@JsonPropertyDescription("")
	private String productNumber;
	/**
	 * The ProductName in the source system
	 * 
	 */
	@JsonProperty("ProductName")
	@JsonPropertyDescription("")
	private String productName;
	/**
	 * The Uom in the source system
	 * 
	 */
	@JsonProperty("Uom")
	@JsonPropertyDescription("")
	private String uom;
	/**
	 * The Ordered Quantity in the source system
	 * 
	 */
	@JsonProperty("OrderedQty")
	@JsonPropertyDescription("")
	private String orderedQty;
	/**
	 * The Shipped Quantity in the source system
	 * 
	 */
	@JsonProperty("ShippedQty")
	@JsonPropertyDescription("")
	private String shippedQty;
	/**
	 * The Line Status in the source system
	 * 
	 */
	@JsonProperty("LineStatus")
	@JsonPropertyDescription("")
	private String lineStatus;
	/**
	 * The Price in the source system
	 * 
	 */
	@JsonProperty("Price")
	@JsonPropertyDescription("")
	private String price;
	/**
	 * The Shipping Method in the source system
	 * 
	 */
	@JsonProperty("ShipMethod")
	@JsonPropertyDescription("")
	private String shipMethod;
	/**
	 * The Tracking Number in the source system
	 * 
	 */
	@JsonProperty("TrackingNumber")
	@JsonPropertyDescription("")
	private String trackingNumber;
	/**
	 * The Proof Status in the source system
	 * 
	 */
	@JsonProperty("ProofStatus")
	@JsonPropertyDescription("")
	private String proofStatus;
	/**
	 * The Hold Status in the source system
	 * 
	 */
	@JsonProperty("HoldStatus")
	@JsonPropertyDescription("")
	private String holdStatus;
	/**
	 * The Shipping Date in the source system
	 * 
	 */
	@JsonProperty("ShipDate")
	@JsonPropertyDescription("")
	private String shipDate;
	/**
	 * The Imprint Color in the source system
	 * 
	 */
	@JsonProperty("ImprintColor")
	@JsonPropertyDescription("")
	private String imprintColor;
	/**
	 * The Imprint Location in the source system
	 * 
	 */
	@JsonProperty("ImprintLocation")
	@JsonPropertyDescription("")
	private String imprintLocation;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * The OrderNumber in the source system (Required)
	 * 
	 * @return The orderNumber
	 */
	@JsonProperty("OrderNumber")
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * The OrderNumber in the source system (Required)
	 * 
	 * @param orderNumber The OrderNumber
	 */
	@JsonProperty("OrderNumber")
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * The OrderLine's ID in the source system (Required)
	 * 
	 * @return The orderLineID
	 */
	@JsonProperty("OrderLineID")
	public String getOrderLineID() {
		return orderLineID;
	}

	/**
	 * The OrderLine's ID in the source system (Required)
	 * 
	 * @param orderLineID The OrderLineID
	 */
	@JsonProperty("OrderLineID")
	public void setOrderLineID(String orderLineID) {
		this.orderLineID = orderLineID;
	}

	/**
	 * The LineNumber in the source system (Required)
	 * 
	 * @return The lineNumber
	 */
	@JsonProperty("LineNumber")
	public String getLineNumber() {
		return lineNumber;
	}

	/**
	 * The LineNumber in the source system (Required)
	 * 
	 * @param lineNumber The LineNumber
	 */
	@JsonProperty("LineNumber")
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * The ProductNumber in the source system
	 * 
	 * @return The productNumber
	 */
	@JsonProperty("ProductNumber")
	public String getProductNumber() {
		return productNumber;
	}

	/**
	 * The ProductNumber in the source system
	 * 
	 * @param productNumber The ProductNumber
	 */
	@JsonProperty("ProductNumber")
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	/**
	 * The ProductName in the source system
	 * 
	 * @return The productName
	 */
	@JsonProperty("ProductName")
	public String getProductName() {
		return productName;
	}

	/**
	 * The ProductName in the source system
	 * 
	 * @param productName The ProductName
	 */
	@JsonProperty("ProductName")
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * The Uom in the source system
	 * 
	 * @return The uom
	 */
	@JsonProperty("Uom")
	public String getUom() {
		return uom;
	}

	/**
	 * The Uom in the source system
	 * 
	 * @param uom The Uom
	 */
	@JsonProperty("Uom")
	public void setUom(String uom) {
		this.uom = uom;
	}

	/**
	 * The Ordered Quantity in the source system
	 * 
	 * @return The orderedQty
	 */
	@JsonProperty("OrderedQty")
	public String getOrderedQty() {
		return orderedQty;
	}

	/**
	 * The Ordered Quantity in the source system
	 * 
	 * @param orderedQty The OrderedQty
	 */
	@JsonProperty("OrderedQty")
	public void setOrderedQty(String orderedQty) {
		this.orderedQty = orderedQty;
	}

	/**
	 * The Shipped Quantity in the source system
	 * 
	 * @return The shippedQty
	 */
	@JsonProperty("ShippedQty")
	public String getShippedQty() {
		return shippedQty;
	}

	/**
	 * The Shipped Quantity in the source system
	 * 
	 * @param shippedQty The ShippedQty
	 */
	@JsonProperty("ShippedQty")
	public void setShippedQty(String shippedQty) {
		this.shippedQty = shippedQty;
	}

	/**
	 * The Line Status in the source system
	 * 
	 * @return The lineStatus
	 */
	@JsonProperty("LineStatus")
	public String getLineStatus() {
		return lineStatus;
	}

	/**
	 * The Line Status in the source system
	 * 
	 * @param lineStatus The LineStatus
	 */
	@JsonProperty("LineStatus")
	public void setLineStatus(String lineStatus) {
		this.lineStatus = lineStatus;
	}

	/**
	 * The Price in the source system
	 * 
	 * @return The price
	 */
	@JsonProperty("Price")
	public String getPrice() {
		return price;
	}

	/**
	 * The Price in the source system
	 * 
	 * @param price The Price
	 */
	@JsonProperty("Price")
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * The Shipping Method in the source system
	 * 
	 * @return The shipMethod
	 */
	@JsonProperty("ShipMethod")
	public String getShipMethod() {
		return shipMethod;
	}

	/**
	 * The Shipping Method in the source system
	 * 
	 * @param shipMethod The ShipMethod
	 */
	@JsonProperty("ShipMethod")
	public void setShipMethod(String shipMethod) {
		this.shipMethod = shipMethod;
	}

	/**
	 * The Tracking Number in the source system
	 * 
	 * @return The trackingNumber
	 */
	@JsonProperty("TrackingNumber")
	public String getTrackingNumber() {
		return trackingNumber;
	}

	/**
	 * The Tracking Number in the source system
	 * 
	 * @param trackingNumber The TrackingNumber
	 */
	@JsonProperty("TrackingNumber")
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	/**
	 * The Proof Status in the source system
	 * 
	 * @return The proofStatus
	 */
	@JsonProperty("ProofStatus")
	public String getProofStatus() {
		return proofStatus;
	}

	/**
	 * The Proof Status in the source system
	 * 
	 * @param proofStatus The ProofStatus
	 */
	@JsonProperty("ProofStatus")
	public void setProofStatus(String proofStatus) {
		this.proofStatus = proofStatus;
	}

	/**
	 * The Hold Status in the source system
	 * 
	 * @return The holdStatus
	 */
	@JsonProperty("HoldStatus")
	public String getHoldStatus() {
		return holdStatus;
	}

	/**
	 * The Hold Status in the source system
	 * 
	 * @param holdStatus The HoldStatus
	 */
	@JsonProperty("HoldStatus")
	public void setHoldStatus(String holdStatus) {
		this.holdStatus = holdStatus;
	}

	/**
	 * The Shipping Date in the source system
	 * 
	 * @return The shipDate
	 */
	@JsonProperty("ShipDate")
	public String getShipDate() {
		return shipDate;
	}

	/**
	 * The Shipping Date in the source system
	 * 
	 * @param shipDate The ShipDate
	 */
	@JsonProperty("ShipDate")
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	/**
	 * The Imprint Color in the source system
	 * 
	 * @return The imprintColor
	 */
	@JsonProperty("ImprintColor")
	public String getImprintColor() {
		return imprintColor;
	}

	/**
	 * The Imprint Color in the source system
	 * 
	 * @param imprintColor The ImprintColor
	 */
	@JsonProperty("ImprintColor")
	public void setImprintColor(String imprintColor) {
		this.imprintColor = imprintColor;
	}

	/**
	 * The Imprint Location in the source system
	 * 
	 * @return The imprintLocation
	 */
	@JsonProperty("ImprintLocation")
	public String getImprintLocation() {
		return imprintLocation;
	}

	/**
	 * The Imprint Location in the source system
	 * 
	 * @param imprintLocation The ImprintLocation
	 */
	@JsonProperty("ImprintLocation")
	public void setImprintLocation(String imprintLocation) {
		this.imprintLocation = imprintLocation;
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
		return new HashCodeBuilder().append(orderNumber).append(orderLineID).append(lineNumber).append(productNumber)
				.append(productName).append(uom).append(orderedQty).append(shippedQty).append(lineStatus).append(price)
				.append(shipMethod).append(trackingNumber).append(proofStatus).append(holdStatus).append(shipDate)
				.append(imprintColor).append(imprintLocation).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof OrderLineData) == false) {
			return false;
		}
		OrderLineData rhs = ((OrderLineData) other);
		return new EqualsBuilder().append(orderNumber, rhs.orderNumber).append(orderLineID, rhs.orderLineID)
				.append(lineNumber, rhs.lineNumber).append(productNumber, rhs.productNumber)
				.append(productName, rhs.productName).append(uom, rhs.uom).append(orderedQty, rhs.orderedQty)
				.append(shippedQty, rhs.shippedQty).append(lineStatus, rhs.lineStatus).append(price, rhs.price)
				.append(shipMethod, rhs.shipMethod).append(trackingNumber, rhs.trackingNumber)
				.append(proofStatus, rhs.proofStatus).append(holdStatus, rhs.holdStatus).append(shipDate, rhs.shipDate)
				.append(imprintColor, rhs.imprintColor).append(imprintLocation, rhs.imprintLocation)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}
