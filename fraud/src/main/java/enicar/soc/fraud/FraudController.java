package enicar.soc.fraud;

import enicar.soc.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudController {
    private final FraudCheckService fraudCheckService;
@GetMapping(path = "{studentId}")
public FraudCheckResponse isFraudster(@PathVariable("studentId")Integer studentID){
    boolean isFraudulentStudent = fraudCheckService.isFraudulentStudent(studentID);
    log.info("fraud check request for customer{}",studentID);
    return new FraudCheckResponse(isFraudulentStudent);
}
}
