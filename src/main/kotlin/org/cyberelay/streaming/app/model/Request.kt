package org.cyberelay.streaming.app.model

import com.azure.spring.data.cosmos.core.mapping.Container
import org.springframework.data.annotation.Id
import java.util.Date

@Container(containerName = "requests")
data class Request(
    @Id val id: String? = null,
    val tenantId: String,
    val lastUpdate: Date,
    val createTime: Date
)
