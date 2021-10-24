package br.com.deteccaoqueda.config

import br.com.deteccaoqueda.handlers.OrientacaoMessageHandler
import br.com.deteccaoqueda.handlers.QuedaMessageHandler
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.springframework.beans.factory.annotation.Value

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.dsl.IntegrationFlow
import org.springframework.integration.dsl.IntegrationFlows
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory
import org.springframework.integration.mqtt.core.MqttPahoClientFactory
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter

@Configuration
class MqttConfiguration (
    @Value("\${mqtt.user.name}") val mqttUserName: String,
    @Value("\${mqtt.user.password}") val mqttPassword: String,
    @Value("\${mqtt.url}") val mqttIpAddress: String,
    @Value("\${mqtt.port}") val mqttPort: String,
    @Value("\${mqtt.topic.queda}") val mqttTopicQueda: String,
    @Value("\${mqtt.topic.orientacao}") val mqttTopicOrientacao: String
        ) {

    @Bean
    fun mqttClientFactory(): MqttPahoClientFactory {
        val options = MqttConnectOptions()
        options.serverURIs =
            arrayOf(String.format("tcp://%s:%s", mqttIpAddress, mqttPort))
            options.userName = mqttUserName
            options.password = mqttPassword.toCharArray()
        val factory = DefaultMqttPahoClientFactory()
        factory.connectionOptions = options
        return factory
    }

    @Bean
    fun mqttInbound(
        mqttClientFactory: MqttPahoClientFactory?,
        quedaMessageHandler: QuedaMessageHandler?
    ): IntegrationFlow {
        return IntegrationFlows.from(
            MqttPahoMessageDrivenChannelAdapter("mqtt-service-queda", mqttClientFactory, mqttTopicQueda)
        )
            .handle(quedaMessageHandler)
            .get()
    }

    @Bean
    fun mqttInboundOrientacao(
        mqttClientFactory: MqttPahoClientFactory?,
        orientacaoMessageHandler: OrientacaoMessageHandler?
    ): IntegrationFlow {
        return IntegrationFlows.from(
            MqttPahoMessageDrivenChannelAdapter("mqtt-service-orientacao", mqttClientFactory, mqttTopicOrientacao)
        )
            .handle(orientacaoMessageHandler)
            .get()
    }
}
