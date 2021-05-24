package com.meli.testMeli;

import com.meli.testMeli.Controller.MutantController;
import com.meli.testMeli.Service.MutantVerifyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MutantTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MutantVerifyService mutantVerifyService;

    String requestString = "{\"dna\" : [ \"ATGCGAAA\",\"CAGTGCSS\",\"TTATGTDD\",\"AGAAGGFF\",\"CCCCTAGG\",\"TCACTGGG\",\"CCCCTAGG\",\"TCACTGGG\"]}";
    String[] dna = {"ATGCGAAA","CAGTGCSS","TTATGTDD","AGAAGGFF","CCCCTAGG","TCACTGGG","CCCCTAGG","TCACTGGG"};

    String requestFail = "{\"dna\" : [\"BB\", \"CC\"]}";
    String[] dnaFail = {"BB", "CC"};

    @Test
    public void mutantVerifyTestOk() throws Exception {
        Mockito.when(mutantVerifyService.isMutant(dna)).thenReturn(true);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/mutant/verify")
                .accept(MediaType.APPLICATION_JSON).content(requestString)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

    @Test
    public void mutantVerifyTestFail() throws Exception {
        Mockito.when(mutantVerifyService.isMutant(dnaFail)).thenReturn(false);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/mutant/verify")
                .accept(MediaType.APPLICATION_JSON).content(requestFail)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatus());

    }

}
