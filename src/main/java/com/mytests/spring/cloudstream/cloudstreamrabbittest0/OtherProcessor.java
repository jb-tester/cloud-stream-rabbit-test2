package com.mytests.spring.cloudstream.cloudstreamrabbittest0;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 11/1/2018.
 * Project: cloud-stream-rabbit-test0
 * *******************************
 */
public interface OtherProcessor {
    @Input
    SubscribableChannel myInput1();
    @Output
    MessageChannel myOutput1();
}
