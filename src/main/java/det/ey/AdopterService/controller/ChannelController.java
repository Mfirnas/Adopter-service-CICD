package det.ey.AdopterService.controller;

import det.ey.AdopterService.entity.RabbitMqQueue;
import det.ey.AdopterService.entity.Topic;
import det.ey.AdopterService.repo.QueueRepo;
import det.ey.AdopterService.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/event")
public class ChannelController {

    @Autowired
    TopicRepo repo;

    @Autowired
    QueueRepo queueRepo;

    @PostMapping("/topic")
    public void addTopic(@RequestBody Topic topic){
        System.out.println("Topic added to redis "+topic);
        repo.save(topic);
    }

    @GetMapping("/topics")
    public List<Topic> findAll(){
        List<Topic> topics= (List<Topic>) repo.findAll();
        return topics;
    }

    @PostMapping("/queue")
    public void addQueue(@RequestBody RabbitMqQueue queue){
        queueRepo.save(queue);
        System.out.println("Queue added to redis "+queue);
    }

    @GetMapping("/queues")
    public List<RabbitMqQueue> findAllQueue(){
        return (List<RabbitMqQueue>) queueRepo.findAll();
    }

    @GetMapping("/find")
    public Optional<RabbitMqQueue> findQueueByKey(@RequestParam("key") String key){
        System.out.println("called");
        System.out.println(key);
       // RabbitMqQueue queue=queueRepo.findRabbitMqQueueByKey(key);
       // System.out.println(queue);
        return queueRepo.findById(key);
    }
}
