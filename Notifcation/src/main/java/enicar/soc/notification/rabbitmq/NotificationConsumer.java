package enicar.soc.notification.rabbitmq;

import enicar.soc.clients.notifcation.NotificationRequest;
import enicar.soc.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
    public final NotificationService notificationService;
    @RabbitListener(queues = {"${rabbitmq.queues.notification}"})
    public void consumer(NotificationRequest notificationRequest){
    log.info("consumed {} from queue",notificationRequest);
    notificationService.send(notificationRequest);
    }
}
