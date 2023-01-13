package enicar.soc.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages ={
        "enicar.soc.student",
        "enicar.soc.amqp"
} )
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "enicar.soc.clients"
)
public class StudentApplication {
    public static void main(String[] args) {

        SpringApplication.run(StudentApplication.class,args);

    }
}
