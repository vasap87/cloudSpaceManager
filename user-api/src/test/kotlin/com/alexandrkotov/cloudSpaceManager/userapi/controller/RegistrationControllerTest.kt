package com.alexandrkotov.cloudSpaceManager.userapi.controller

import com.alexandrkotov.cloudSpaceManager.userapi.model.WebUser
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@RunWith(SpringRunner::class)
@WebAppConfiguration
@WebMvcTest
class RegistrationControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `controller can save new user`() {
        val webUser = WebUser("user", "password")
        val mapper = ObjectMapper()
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
        val ow = mapper.writer().withDefaultPrettyPrinter()
        val requestJson = ow.writeValueAsString(webUser)
        mockMvc.perform(post("/registration").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
            .andDo(print())
            //.andExpect(status().isOk)
    }
}