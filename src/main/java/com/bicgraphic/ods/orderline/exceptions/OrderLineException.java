/**
 * 
 */
package com.bicgraphic.ods.orderline.exceptions;

import org.springframework.stereotype.Component;

/**
 * @author dhanunjaya.potteti
 *
 */
@Component
public class OrderLineException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String orderLineResCode = null;
	private String orderLineResMsg = null;

	public OrderLineException(String orderLineResMsg) {
		super();
		this.orderLineResMsg = orderLineResMsg;
	}

	public OrderLineException() {
		super();
	}

	public OrderLineException(String orderLineResCode, String orderLineResMsg) {
		super();
		this.orderLineResCode = orderLineResCode;
		this.orderLineResMsg = orderLineResMsg;
	}

	public String getOrderLineResCode() {
		return orderLineResCode;
	}

	public void setOrderLineResCode(String orderLineResCode) {
		this.orderLineResCode = orderLineResCode;
	}

	public String getOrderLineResMsg() {
		return orderLineResMsg;
	}

	public void setOrderLineResMsg(String orderLineResMsg) {
		this.orderLineResMsg = orderLineResMsg;
	}

}
