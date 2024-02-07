package com.enjoy.pairPro.repository

import jakarta.persistence.*
import org.springframework.data.repository.CrudRepository
import java.util.*

interface MasaRepository : CrudRepository<MasaEntity, UUID>

@Entity
@Table(name = "masas")
class MasaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val name: String,
    val age: Int,
)