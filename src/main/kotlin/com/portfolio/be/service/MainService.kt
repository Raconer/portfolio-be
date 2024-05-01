package com.portfolio.be.service

import com.portfolio.be.entity.Main
import com.portfolio.be.repository.MainRepository
import com.portfolio.be.repository.impl.MainRepositoryImpl
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class MainService(
    private val mainRepository: MainRepository,
    private val mainRepositoryImpl: MainRepositoryImpl
) {
    // CREATE
    fun save(){
        val main = Main(name = "테스트 이름", createAt = LocalDateTime.now())
        this.mainRepository.save(main)
    }

    // READ
    fun find():List<Main>{
        return this.mainRepositoryImpl.findAll()
    }
}