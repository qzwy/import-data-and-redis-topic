package zwy.importdata.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.AbstractMessageBrokerConfiguration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.socket.config.annotation.*;


/**
 * EnableWebSocketMessageBroker注解表示开启使用STOMP协议来传输基于代理的消息, Broker就是代理的意思
 * registerStompEndpoints 添加服务端
 * addEndpoint 添加一个/app节点, 客户端用来连接
 * withSockJS 支持SockJS协议
 *
 * @author Qzwy
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
    /**
     * 注册Stomp的节点,并制定使用SockJS协议,同时设置跨域
     *
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/my-websocket").setAllowedOrigins("*").withSockJS();
    }
    /**
     * 配置消息代理 实现推送功能, 使用/topic
     *
     * @param config
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        //服务端发送的域
        config.enableSimpleBroker("/topic");
    }
}