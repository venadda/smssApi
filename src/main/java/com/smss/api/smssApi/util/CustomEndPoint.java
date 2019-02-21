package com.smss.api.smssApi.util;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class CustomEndPoint implements Endpoint {

    @Override
    public String id() {
        return "Test";
    }

    @Override
    public boolean enableByDefault() {
        return true;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
