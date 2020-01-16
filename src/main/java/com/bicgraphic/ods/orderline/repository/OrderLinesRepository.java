/**
 * 
 */
package com.bicgraphic.ods.orderline.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bicgraphic.ods.orderline.model.OrderLine;

/**
 * @author dhanunjaya.potteti
 *
 */
@Repository
public interface OrderLinesRepository extends MongoRepository<OrderLine, String> {

	public List<OrderLine> findByOrderNumber(String keyValue);
}
