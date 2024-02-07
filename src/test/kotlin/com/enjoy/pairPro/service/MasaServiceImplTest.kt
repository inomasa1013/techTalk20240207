package com.enjoy.pairPro.service

import com.enjoy.pairPro.repository.MasaEntity
import com.enjoy.pairPro.repository.MasaRepository
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith


@ExtendWith(MockKExtension::class)
class MasaServiceImplTest {
    @MockK
    lateinit var stubMasaRepository: MasaRepository

    @Test
    fun `getAllMasas() returns list of masas`() {
        every {
            stubMasaRepository.findAll()
        } returns listOf(
            MasaEntity(name = "name", age = 8)
        )
        val masaService = MasaServiceImpl(stubMasaRepository)
        val result = masaService.getAllMasas()

        assertEquals(1, result.size)
        verify(exactly = 1) {
            stubMasaRepository.findAll()
        }
    }
}