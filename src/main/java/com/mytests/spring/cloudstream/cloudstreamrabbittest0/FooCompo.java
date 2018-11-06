package com.mytests.spring.cloudstream.cloudstreamrabbittest0;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 11/1/2018.
 * Project: cloud-stream-rabbit-test0
 * *******************************
 */
@Component("fooCompo111")
public class FooCompo {

    @Value("foo")
    String id;

    public void setCount(int count) {
        this.count = count;
    }

    private int count = 100;

    public int getCount() {
        return count;
    }

    public String getId() {
        return id;
    }
}
