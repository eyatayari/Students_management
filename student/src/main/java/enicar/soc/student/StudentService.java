package enicar.soc.student;

import enicar.soc.clients.fraud.FraudCheckResponse;
import enicar.soc.clients.fraud.FraudClient;
import enicar.soc.clients.notifcation.NotificationClient;
import enicar.soc.clients.notifcation.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class StudentService {
private final StudentRepository studentRepository;
private final RestTemplate restTemplate;
private final FraudClient fraudClient;
private final NotificationClient notificationClient;
    public void registerCustomer(StudentRegistrationRequest request) {

                Student student= Student.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();
        studentRepository.saveAndFlush(student);
                // todo: check if fraudster

       FraudCheckResponse fraudCheckResponse =fraudClient.isFraudster(student.getId());
       if(fraudCheckResponse.isFraudster()){
           throw new IllegalStateException("fraudster");
       }
                // todo : send notification
        notificationClient.sendNotification(new NotificationRequest(
                student.getId(),student.getEmail(),String.format(

                "hi%s, welcome to enicar",student.getFirstname()
        )));

    }
}
