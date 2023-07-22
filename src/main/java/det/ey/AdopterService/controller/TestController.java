package det.ey.AdopterService.controller;

import det.ey.AdopterService.adopter.Validator;
import det.ey.AdopterService.entity.Topic;
import det.ey.AdopterService.producer.AdopterProducerRabbitMq;
import det.ey.AdopterService.repo.TopicRepo;
import det.ey.validationService.dto.BookingInfoDto;
import org.apache.kafka.common.protocol.types.Field;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
  private   Validator validator;
   private AdopterProducerRabbitMq adopterProducerRabbitMq;

    public TestController(AdopterProducerRabbitMq adopterProducerRabbitMq) {
        this.adopterProducerRabbitMq = adopterProducerRabbitMq;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/test",
            headers = "Accept=application/json")
    public ResponseEntity<String> testMethod(@RequestHeader String key, @RequestBody String object){
         JSONObject payload= new JSONObject(object);
         System.out.println(payload.toString());
       // adopterProducerRabbitMq.publishToPayment(infoDto);
      //  adopterProducerRabbitMq.validateExchange(payload,key);
        validator.validateExchange(payload,key);
        return  ResponseEntity.ok("message sent to payment exchange");
    }


}
