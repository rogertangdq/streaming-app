package org.cyberelay.streaming.app.config
import com.azure.cosmos.ConsistencyLevel
import com.azure.cosmos.CosmosClientBuilder
import com.azure.cosmos.implementation.ConnectionPolicy
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@Configuration
@EnableCosmosRepositories(basePackages = ["org.cyberelay.streaming.app.repository"])
class RcarCosmosConfig: AbstractCosmosConfiguration() {

    @Value("\${azure.cosmos.uri}")
    private lateinit var cosmosUri: String

    @Value("\${azure.cosmos.key}")
    private lateinit var cosmosKey: String

    @Value("\${azure.cosmos.database}")
    private lateinit var cosmosDb: String

    @Value("\${azure.cosmos.query-consistency-level:EVENTUAL}")
    private lateinit var consistencyLevel: String

    override fun getDatabaseName(): String {
        return cosmosDb
    }

    @Bean
    fun cosmosClientBuilder(): CosmosClientBuilder {
        return CosmosClientBuilder()
            .endpoint(cosmosUri)
            .key(cosmosKey)
            .consistencyLevel(ConsistencyLevel.valueOf(consistencyLevel))
    }

    private fun disableSSLValidation(): SSLContext {
        val trustAllCertificates = object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
            override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
        }

        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, arrayOf<TrustManager>(trustAllCertificates), java.security.SecureRandom())

        return sslContext
    }
}
