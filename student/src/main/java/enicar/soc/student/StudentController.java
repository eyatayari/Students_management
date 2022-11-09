package enicar.soc.student;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService StudentService;
@PostMapping
    public void RegisterStudent(@RequestBody StudentRegistrationRequest studentRegistrationRequest){
        log.info("new student {}",studentRegistrationRequest);
        StudentService.registerCustomer(studentRegistrationRequest);
    }
}
