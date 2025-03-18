package org.cyberelay.streamingapp.repository

import com.azure.spring.data.cosmos.repository.CosmosRepository
import org.cyberelay.streamingapp.model.Request
import org.springframework.stereotype.Repository

@Repository
interface RequestRepository: CosmosRepository<Request, String> {

}