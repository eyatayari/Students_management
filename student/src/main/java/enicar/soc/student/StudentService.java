package enicar.soc.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class StudentService {
private final StudentRepository studentRepository;
private final RestTemplate restTemplate;
    public void registerCustomer(StudentRegistrationRequest request) {

                Student student= Student.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();
        studentRepository.saveAndFlush(student);
                // todo: check if fraudster
       FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://localhost:8000/api/v1/fraud-check/{studenId}",
                FraudCheckResponse.class,
                student.getId());
       if(fraudCheckResponse.isFraudster()){
           throw new IllegalStateException("fraudster");
       }
                // todo : send notification

    }
}
