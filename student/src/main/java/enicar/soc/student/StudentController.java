package enicar.soc.student;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping( "api/v1")

public class StudentController {
    private final StudentService StudentService;
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/")
    public String index(Principal principal){
        return principal.getName();
    }
@PostMapping("/students")

    public void RegisterStudent(@RequestBody StudentRegistrationRequest studentRegistrationRequest){
        log.info("new student {}",studentRegistrationRequest);
        StudentService.registerCustomer(studentRegistrationRequest);
    }
    @GetMapping("/all")

    public String students(){
        //model.addAttribute("students",studentRepository.findAll());
        return "test";
    }

}
