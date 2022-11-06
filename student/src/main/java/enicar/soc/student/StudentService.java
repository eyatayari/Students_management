package enicar.soc.student;

import org.springframework.stereotype.Service;

@Service
public record StudentService(StudentRepository studentRepository) {

    public void registerCustomer(StudentRegistrationRequest request) {
        Student student = Student.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();
        studentRepository.save(student);
    }
}
