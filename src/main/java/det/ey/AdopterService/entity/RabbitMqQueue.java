package det.ey.AdopterService.entity;

import lombok.Data;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@RedisHash("RabbitMqQueue")
public class RabbitMqQueue implements Serializable {

    private String id;
    private  String exchange;
    private  String queue;

   // private String  key;
    private String  exchangeKey;
}
