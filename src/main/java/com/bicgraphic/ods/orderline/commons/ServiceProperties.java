/**
 * 
 */
package com.bicgraphic.ods.orderline.commons;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author dhanunjaya.potteti
 *
 */
@Component
@PropertySource(value = "classpath:ods_event.properties")
public class ServiceProperties {

	@Value("${service.event.endpoint}")
	private String eventEndpoint;

	public String getEventEndpoint() {
		return eventEndpoint;
	}

	public void setEventEndpoint(String eventEndpoint) {
		this.eventEndpoint = eventEndpoint;
	}

}
