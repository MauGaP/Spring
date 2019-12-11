package com.mpedano.spring.messageexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    @Bean
    public SetterMessage getSetterMessage() {
        SetterMessage setterMessage = new SetterMessage();
        setterMessage.setMessage("Spring is fun");

        return setterMessage;
    }
}
