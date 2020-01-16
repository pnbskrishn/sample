package com.bicgraphic.ods.orderline.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.WebApplicationContext;

import com.bicgraphic.ods.orderline.OrderLineApplication;
import com.bicgraphic.ods.orderline.model.OrderlinePullEventDMRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrderLineApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderLineIngestionAPIControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void pullWebsiteOrderLines1() throws Exception {

		File file = ResourceUtils.getFile("classpath:orderline_testdata.json");
		ObjectMapper mapper = new ObjectMapper();
		OrderlinePullEventDMRequest event = mapper.readValue(file, OrderlinePullEventDMRequest.class);
		String eventJson = mapper.writeValueAsString(event);
		mockMvc.perform(
				post("/orderlines/pullWebsiteOrderLines").contentType(MediaType.APPLICATION_JSON).content(eventJson))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$..EventStatus").value("SUCCESS"));
	}

	@Test
	public void pullWebsiteOrderLines2() throws Exception {
		File file = ResourceUtils.getFile("classpath:orderline_testdata.json");
		ObjectMapper mapper = new ObjectMapper();
		OrderlinePullEventDMRequest event = mapper.readValue(file, OrderlinePullEventDMRequest.class);
		event.getEventRequest().getRequestRecords().getRequestRecord().get(0).setKeyValue("111");
		String eventJson = mapper.writeValueAsString(event);
		mockMvc.perform(
				post("/orderlines/pullWebsiteOrderLines").contentType(MediaType.APPLICATION_JSON).content(eventJson))
				.andExpect(status().isOk()).andExpect(jsonPath("$..EventErrorCode").value("INTERR-114"))
				.andExpect(jsonPath("$..EventStatusMessage").value("No Records found for given input"));
	}

	@Test
	public void pullWebsiteOrderLines3() throws Exception {
		File file = ResourceUtils.getFile("classpath:orderline_testdata.json");
		ObjectMapper mapper = new ObjectMapper();
		OrderlinePullEventDMRequest event = mapper.readValue(file, OrderlinePullEventDMRequest.class);
		event.getEventRequest().setEventType(null);
		String eventJson = mapper.writeValueAsString(event);
		mockMvc.perform(
				post("/orderlines/pullWebsiteOrderLines").contentType(MediaType.APPLICATION_JSON).content(eventJson))
				.andExpect(status().isOk()).andExpect(jsonPath("$..EventErrorCode").value("INTERR-113"))
				.andExpect(jsonPath("$..EventStatusMessage").value("Incorrect request field value"));
	}

}
