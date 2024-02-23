package kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class kafkaConfiguration {
    @Bean
public NewTopic newTopic(){
        return new NewTopic("course", 1,(short) 1);
    }

}
