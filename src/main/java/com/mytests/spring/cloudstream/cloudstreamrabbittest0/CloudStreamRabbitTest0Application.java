package com.mytests.spring.cloudstream.cloudstreamrabbittest0;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;


@SpringBootApplication
@EnableBinding({MyProcessor.class, OtherProcessor.class})
public class CloudStreamRabbitTest0Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitTest0Application.class, args);
    }



    @StreamListener(target = "myFooInput")
    @SendTo("myFooOutput")
    public Integer readValues(@Payload("compareTo(5000)") Integer val) {
    //public Integer readValues(@Payload("@fooCompo111.count") Integer val) {

        System.out.println("**********************************");
        System.out.println("got " + val);
        System.out.println("**********************************");
        return val+1000;
    }




    @ServiceActivator(inputChannel = "myFooOutput", outputChannel = "out")
    public String transform(Integer payload) {
        return "processed "+payload;
    }

    @Bean
    public PollableChannel out() {
        return new QueueChannel();
    }

}
