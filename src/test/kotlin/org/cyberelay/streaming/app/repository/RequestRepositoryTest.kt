package org.cyberelay.streaming.app.repository

import org.cyberelay.streaming.app.model.Request
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.Instant
import java.util.*

@SpringBootTest
class RequestRepositoryTest {

    @Autowired
    private lateinit var repository: RequestRepository

    @Test
    fun testSaveRequest() {
        var request = Request(
            id = UUID.randomUUID().toString(),
            tenantId = UUID.randomUUID().toString(),
            lastUpdate = Date.from(Instant.now()),
            createTime = Date.from(Instant.now())
        )
        request = repository.save(request)
        assert(request.id != null)
    }

}