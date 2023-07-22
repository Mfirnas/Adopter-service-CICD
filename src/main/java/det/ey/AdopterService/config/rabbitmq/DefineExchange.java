package det.ey.AdopterService.config.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
@RequiredArgsConstructor
@Slf4j
public class DefineExchange {


    private final RabbitAdmin rabbitAdmin;





    public void createExchange(){
        System.out.println("hello");
        rabbitAdmin.declareExchange(ExchangeBuilder
               .directExchange("Test_1").build());
    }

}
