package com.lubaspc.domain.usecase

import com.lubaspc.domain.model.Test
import javax.inject.Inject


class GetTests(@Inject private val testRepository: GetTests.GetTestsSource): UseCase() {
    fun invoke() = testRepository.getTestList()

    interface GetTestsSource {
        fun getTestList(): List<Test>
    }
}