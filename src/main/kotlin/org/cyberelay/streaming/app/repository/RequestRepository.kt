package org.cyberelay.streaming.app.repository

import com.azure.spring.data.cosmos.repository.CosmosRepository
import org.cyberelay.streaming.app.model.Request
import org.springframework.stereotype.Repository

@Repository
interface RequestRepository: CosmosRepository<Request, String>