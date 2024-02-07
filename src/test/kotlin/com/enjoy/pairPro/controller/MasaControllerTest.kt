package com.enjoy.pairPro.controller

import com.enjoy.pairPro.service.MasaService
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockKExtension::class)
class MasaControllerTest {
    @MockK
    lateinit var stubMasaService: MasaService

    @Test
    fun `getAllMasas() returns status 200`() {
        val mockMVC = MockMvcBuilders.standaloneSetup(MasaController(stubMasaService)).build()

        mockMVC.perform(get("/api/v1/masa"))
            .andExpect(status().isOk)
    }

    @Test
    fun `getAllMasas() returns list of Masa`() {
        every {
            stubMasaService.getAllMasas()
        } returns listOf(Masa("masa", 30))
        val mockMVC = MockMvcBuilders.standaloneSetup(MasaController(stubMasaService)).build()

        mockMVC.perform(get("/api/v1/masa"))
            .andExpect(jsonPath("$").isArray)
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].name").value("masa"))
            .andExpect(jsonPath("$[0].age").value(30))

        verify(exactly = 1) {
            stubMasaService.getAllMasas()
        }
    }
}