package det.ey.AdopterService.repo;

import det.ey.AdopterService.entity.RabbitMqQueue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QueueRepo extends CrudRepository<RabbitMqQueue,String> {

}
