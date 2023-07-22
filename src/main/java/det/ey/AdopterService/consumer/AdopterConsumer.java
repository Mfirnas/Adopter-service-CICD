package det.ey.AdopterService.consumer;


import det.ey.AdopterService.producer.AdopterProducerRabbitMq;
import det.ey.validationService.dto.BookingInfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AdopterConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdopterConsumer.class);
   private AdopterProducerRabbitMq adopterProducerRabbitMq;

    public AdopterConsumer(AdopterProducerRabbitMq adopterProducerRabbitMq) {
        this.adopterProducerRabbitMq = adopterProducerRabbitMq;
    }

    @KafkaListener(topics = "validation", groupId = "myGroup")
    public void consume(BookingInfoDto infoDto){
        LOGGER.info(String.format("Json message recieved -> %s", infoDto.toString()));

        adopterProducerRabbitMq.publishBookingDto(infoDto);

    }


}
