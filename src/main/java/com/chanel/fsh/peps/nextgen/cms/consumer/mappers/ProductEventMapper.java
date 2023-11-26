package com.chanel.fsh.peps.nextgen.cms.consumer.mappers;

import com.chanel.fsh.peps.nextgen.cms.consumer.dtos.ProductEventDto;
import com.chanel.fsh.peps.nextgen.cms.domain.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEventMapper {
    Product toModel(ProductEventDto productEventDto);
}
