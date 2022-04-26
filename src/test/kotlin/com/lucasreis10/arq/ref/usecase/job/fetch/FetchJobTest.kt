package com.lucasreis10.arq.ref.usecase.job.fetch

import com.lucasreis10.arq.ref.usecase.job.JobRepositoryInterface
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.anyString
import org.mockito.Mockito.`when`


class FetchJobTest {

    private var repository = Mockito.mock(JobRepositoryInterface::class.java)

    @Test
    fun fetch() {
        // setup:
        `when`(repository.fetchJob(anyString(), anyString())).thenReturn(FetchJobTestHelper.job())
        val input = FetchJobTestHelper.inputFindJobDto(job = "client-name-932312")
        // execute:
        val output = FetchJobUseCase(repository).execute(input)
        // verify:
        Assertions.assertEquals(output?.gsi1pk, "pk-1234")
    }

}
