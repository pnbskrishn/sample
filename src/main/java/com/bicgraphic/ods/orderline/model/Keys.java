/**
 * 
 */
package com.bicgraphic.ods.orderline.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author dhanunjaya.potteti
 *
 */
@Component
public class Keys {

	@JsonProperty("KeyName")
	@NotBlank(message = "{validation.KeyName.notNull}")
	private String KeyName;
	
	@JsonProperty("KeyValue")
	@NotBlank(message = "{validation.KeyValue.notNull}")
	private String KeyValue;

	public String getKeyName() {
		return KeyName;
	}

	public void setKeyName(String keyName) {
		KeyName = keyName;
	}

	public String getKeyValue() {
		return KeyValue;
	}

	public void setKeyValue(String keyValue) {
		KeyValue = keyValue;
	}

}
