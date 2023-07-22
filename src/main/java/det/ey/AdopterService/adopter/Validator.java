package det.ey.AdopterService.adopter;

import det.ey.AdopterService.config.rabbitmq.DefineExchange;
import det.ey.AdopterService.repo.QueueRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class Validator {

    @Autowired
    QueueRepo repo;

       @Autowired
       DefineExchange exchange;
    public void validateExchange(JSONObject object, String key){
          exchange.createExchange();
       // Optional<RabbitMqQueue> queue=repo.findById(key);


    }


}
