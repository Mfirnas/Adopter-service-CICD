package det.ey.AdopterService.config.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue(){
        return new Queue("booking_queue");
    }

    @Bean
    public Queue jsonQue(){
        return  new Queue("booking_dto_que");
    }

    //spring bean for rabbitmq
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("booking_exchange");
    }

    //spring bean for rabbitmq binding
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with("booking_key");
    }

    @Bean
    public  Binding jsonBinding(){

        return BindingBuilder
                .bind(jsonQue())
                .to(exchange())
                .with("booking_json_key");
    }


    //payment
    @Bean
    public Queue jsonPaymentQue(){
        return  new Queue("payment_que");
    }

    @Bean
    public TopicExchange paymentExchange(){
        return new TopicExchange("payment_exchange");
    }

    @Bean
    public  Binding paymentBinding(){

        return BindingBuilder
                .bind(jsonPaymentQue())
                .to(paymentExchange())
                .with("payment_json_key");
    }
//////////////////////////////////////////////////


///////////////////////////////
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
