package det.ey.AdopterService.repo;

import det.ey.AdopterService.entity.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepo extends CrudRepository<Topic,Integer> {
}
