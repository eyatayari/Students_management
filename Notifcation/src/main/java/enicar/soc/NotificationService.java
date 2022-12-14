package enicar.soc;

import enicar.soc.clients.notifcation.NotificationClient;
import enicar.soc.clients.notifcation.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    public void send(NotificationRequest notificationRequest){

        notificationRepository.save(Notification.builder()
                .content(notificationRequest.content())
                .receiver_email(notificationRequest.receiver_email())
                .sender("enicar")

                .build());
    }
}
