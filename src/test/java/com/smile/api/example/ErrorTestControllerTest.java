package com.smile.api.example;

import com.smile.api.golbal.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ErrorTestController.class)
class ErrorTestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Restcontroller request param miss match error Response")
    void methodArgumentTypeMismatchExeption() throws Exception {
        mockMvc.perform(get("/error/parameterError")
                        .param("integer", "aaa"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is(ErrorCode.INVALID_PARAMETER.getErrorCode())))
                .andExpect(jsonPath("$.errorMsg", is(ErrorCode.INVALID_PARAMETER.getErrorMsg())));
    }

    @Test
    @DisplayName("Restcontroller request param miss match error Response")
    void methodNotAllow() throws Exception {
        mockMvc.perform(post("/error/parameterError"))
                .andExpect(status().isMethodNotAllowed())
                .andExpect(jsonPath("$.errorCode", is(ErrorCode.METHOD_NOT_ALLOWED.getErrorCode())))
                .andExpect(jsonPath("$.errorMsg", is(ErrorCode.METHOD_NOT_ALLOWED.getErrorMsg())));
    }

}