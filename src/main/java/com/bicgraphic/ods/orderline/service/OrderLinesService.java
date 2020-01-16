/**
 * 
 */
package com.bicgraphic.ods.orderline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bicgraphic.ods.orderline.model.Keys;
import com.bicgraphic.ods.orderline.model.OrderLines;

/**
 * @author dhanunjaya.potteti
 *
 */
@Service
public interface OrderLinesService {

	OrderLines getOrderLines(List<Keys> requestRecord);

}
