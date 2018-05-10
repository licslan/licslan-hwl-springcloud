package com.licslan.service;

import org.springframework.stereotype.Component;

/**
 * Created by
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}