package com.miaoshaproject;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AppWebMvcTest {

    @Test
    public void shouldReturnReferenceProjectMetadataAtRoot() throws Exception {
        App app = new App();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(app).build();

        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith("application/json"))
            .andExpect(jsonPath("$.status").value("UP"))
            .andExpect(jsonPath("$.project").value("miaosha"))
            .andExpect(jsonPath("$.type").value("flash-sale-reference"));
    }
}
