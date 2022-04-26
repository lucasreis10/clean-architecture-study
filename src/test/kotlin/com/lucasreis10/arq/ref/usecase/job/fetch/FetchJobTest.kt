package com.lucasreis10.arq.ref.usecase.job.fetch

import com.lucasreis10.arq.ref.domain.job.JobRepositoryInterface
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.anyString


class FetchJobTest {

    private var repository = Mockito.mock(JobRepositoryInterface::class.java)

    @BeforeAll
    fun setup() {
        Mockito.`when`(repository.fetchJob(anyString(), anyString())).thenReturn(FetchJobTestHelper.job())
    }

    @Test
    fun fetch() {
        // setup:
        val input = FetchJobTestHelper.inputFindJobDto(job = "client-name-932312")
        // execute:
        val output = FetchJobUseCase(repository).execute(input)
        // verify:
        Assertions.assertEquals(output?.gsi1pk, "pk-1234")
    }

}
