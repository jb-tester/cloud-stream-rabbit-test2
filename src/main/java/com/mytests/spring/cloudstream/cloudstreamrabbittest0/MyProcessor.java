package com.mytests.spring.cloudstream.cloudstreamrabbittest0;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyProcessor {
    String INPUT = "myFooInput";
 
    @Input(INPUT)
    SubscribableChannel myInput();


 
    @Output("myFooOutput")
    MessageChannel anOutput();

}