package com.chanel.fsh.peps.nextgen.cms.consumer;

import com.chanel.fsh.peps.nextgen.cms.consumer.dtos.ProductEventDto;
import com.chanel.fsh.peps.nextgen.cms.consumer.exception.ConsumerException;
import com.chanel.fsh.peps.nextgen.cms.consumer.mappers.ProductEventMapper;
import com.chanel.fsh.peps.nextgen.cms.domain.models.Product;
import com.chanel.fsh.peps.nextgen.cms.domain.services.CMSContainerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ProductEventConsumerConfig {

    private CMSContainerService cmsContainerService;
    private ProductEventMapper productEventMapper;

    @Bean
    public Function<String, String> processProductEvents() {
        return value -> {
            try {
                ProductEventDto productEventDto = new ObjectMapper().readValue(value, ProductEventDto.class);
                Product product = productEventMapper.toModel(productEventDto);
                cmsContainerService.processProductEvent(product);
            } catch (JsonProcessingException e) {
                throw new ConsumerException(e.getMessage());
            }
            return value;
        };
    }

    public ProductEventConsumerConfig(CMSContainerService cmsContainerService, ProductEventMapper productEventMapper) {
        this.cmsContainerService = cmsContainerService;
        this.productEventMapper = productEventMapper;
    }
}
