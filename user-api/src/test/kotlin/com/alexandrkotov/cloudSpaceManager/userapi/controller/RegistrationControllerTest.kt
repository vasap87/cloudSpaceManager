package com.alexandrkotov.cloudSpaceManager.userapi.controller

import com.alexandrkotov.cloudSpaceManager.userapi.model.WebUser
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class RegistrationControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun `controller can save new user`() {
        val webUser = WebUser("user", "password")
        val mapper = ObjectMapper()
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
        val ow = mapper.writer().withDefaultPrettyPrinter()
        val requestJson = ow.writeValueAsString(webUser)
        mockMvc.perform(
            post("/registration")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson)
        )
            .andDo(print())
            .andExpect(status().isOk)
    }
}