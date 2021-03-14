package com.lubaspc.domain.usecase

import com.lubaspc.domain.model.Test
import javax.inject.Inject

class TestUseCase(@Inject private val testRepository: TestSource) {

    fun getTest(): Test? = testRepository.getTest()
    fun getTestLast(): Test? = testRepository.getTestLast()
    fun getTests(): List<Test> = testRepository.getTestList()

    interface TestSource{
        fun getTestList(): List<Test>
        fun getTest(): Test?
        fun getTestLast(): Test?
    }
}