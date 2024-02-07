package com.enjoy.pairPro.service

import com.enjoy.pairPro.controller.Masa
import com.enjoy.pairPro.repository.MasaRepository
import org.springframework.stereotype.Service

interface MasaService {
    fun getAllMasas(): List<Masa>
}

@Service
class MasaServiceImpl(
    private val masaRepository: MasaRepository
) : MasaService {
    override fun getAllMasas(): List<Masa> {
        return masaRepository.findAll().map { Masa(it.name, it.age) }
    }
}