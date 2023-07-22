package det.ey.AdopterService.producer;

import det.ey.validationService.dto.BookingInfoDto;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdopterProducerRabbitMq {

    private RabbitTemplate rabbitTemplate;

    public AdopterProducerRabbitMq(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public  void publishBookingDto(BookingInfoDto bookingDto){
        System.out.println("Booking DTO set to Exchange :"+bookingDto);
        rabbitTemplate.convertAndSend("booking_exchange","booking_json_key",bookingDto);
    }

    public  void publishToPayment(BookingInfoDto bookingDto){
        System.out.println("Booking DTO set to payment Exchange :"+bookingDto);
        rabbitTemplate.convertAndSend("payment_exchange","payment_json_key",bookingDto);
    }

    public void publishPayload(JSONObject object){

    }
}
