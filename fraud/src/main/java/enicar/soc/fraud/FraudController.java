package enicar.soc.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{studentId")
    public FraudCheckResponse isFraudster(@PathVariable("studentId")Integer studentId){
        boolean isfraudulentStudent= fraudCheckService.isFraudulentStudent(studentId);
        log.info("fraud check request for student {}",studentId);
return new FraudCheckResponse(isfraudulentStudent);
    }
}
