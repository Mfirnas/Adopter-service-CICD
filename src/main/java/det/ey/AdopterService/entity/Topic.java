package det.ey.AdopterService.entity;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Topic")
public class Topic implements Serializable {

    private  int id;
    private  String topicKey;
    private  String topic;

}
