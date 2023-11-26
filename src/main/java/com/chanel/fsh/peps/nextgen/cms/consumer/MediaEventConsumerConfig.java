package com.chanel.fsh.peps.nextgen.cms.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;
import java.util.logging.Logger;

@Configuration
public class MediaEventConsumerConfig {

    private static final Logger logger = Logger.getLogger(MediaEventConsumerConfig.class.getName());

    @Bean
    public Function<String, String> processMediaEvents() {
        return value -> {
            logger.info("Print from Consumer => "+ value);
            return value;
        };
    }
}
