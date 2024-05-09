package com.spring.core.di;

import org.springframework.stereotype.Component;

@Component("sms")
public class SMSService implements  MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}
