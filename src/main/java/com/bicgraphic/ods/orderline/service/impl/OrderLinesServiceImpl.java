/**
 * 
 */
package com.bicgraphic.ods.orderline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicgraphic.ods.orderline.model.Keys;
import com.bicgraphic.ods.orderline.model.OrderLine;
import com.bicgraphic.ods.orderline.model.OrderLines;
import com.bicgraphic.ods.orderline.repository.OrderLinesRepository;
import com.bicgraphic.ods.orderline.service.OrderLinesService;

/**
 * @author dhanunjaya.potteti
 *
 */
@Service
public class OrderLinesServiceImpl implements OrderLinesService {

	@Autowired
	private OrderLinesRepository orderLinesRepository;
	/*
	 * (it will communicate to repository based on key value)
	 * 
	 * @see
	 * com.bicgraphic.ods.orderline.service.OrderLinesService#getOrderLines(java.
	 * lang.String)
	 */

	@Override
	public OrderLines getOrderLines(List<Keys> requestRecord) {
		OrderLines orderLines = new OrderLines();
		// TODO Auto-generated method stub
		for (Keys key : requestRecord) {
			if (key.getKeyName().equalsIgnoreCase("OrderNumber")) {
				List<OrderLine> orderLineList = orderLinesRepository.findByOrderNumber(key.getKeyValue());
				orderLines.setOrderLine(orderLineList);
			}
		}

		return orderLines;

	}

}
