package com.chanel.fsh.peps.nextgen.cms.rest.mappers;

import com.chanel.fsh.peps.nextgen.cms.domain.models.CMSContainer;
import com.chanel.fsh.peps.nextgen.cms.rest.dto.CMSContainerDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CMSContainerDTOMapper {
    CMSContainerDTO toDto(CMSContainer cmsContainer);
}
