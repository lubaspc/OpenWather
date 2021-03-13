package com.lubaspc.domain.usecase

import com.lubaspc.domain.model.Test
import javax.inject.Inject

class GetTest(@Inject private val testRepository: GetTestSource): UseCase() {
    fun invoke() = testRepository.getTest()
    
    interface GetTestSource{
        fun getTest(): Test? 
    }
}