package com.mytests.spring.cloudstream.cloudstreamrabbittest0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 11/6/2018.
 * Project: cloud-stream-rabbit-test0
 * *******************************
 */
@RestController
public class MyController {

    @Qualifier("out")
    @Autowired
    private PollableChannel out;
    @Qualifier("myFooInput")
    @Autowired
    private SubscribableChannel myInput1;

    @RequestMapping("/")
    public String home() {
        myInput1.send(new GenericMessage <>(300));
        String rez = (String) out.receive(0).getPayload();

        return "OK! "+rez;
    }
}
