package enicar.soc.notification;

import enicar.soc.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages ={
        "enicar.soc.notification",
        "enicar.soc.amqp"
} )
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "enicar.soc.clients"
)
public class NotifcationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotifcationApplication.class,args);

    }
//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer , NotificationConfig notificationConfig){
//        return args -> {
//producer.publish(new Person("ali",18),notificationConfig.getInternalExchange(),notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
//    record Person(String name ,int age){};
}
