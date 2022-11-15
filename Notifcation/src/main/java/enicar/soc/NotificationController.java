package enicar.soc;

import enicar.soc.clients.notifcation.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class NotificationController {
    private final  NotificationService notificationService;
   @PostMapping
   public void sendNotification (@RequestBody NotificationRequest notificationRequest){
       log.info("new notification {}",notificationRequest);
       notificationService.send(notificationRequest);
   }
}
