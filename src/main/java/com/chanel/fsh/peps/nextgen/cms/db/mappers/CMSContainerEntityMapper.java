package com.chanel.fsh.peps.nextgen.cms.db.mappers;

import com.chanel.fsh.peps.nextgen.cms.db.entities.CMSContainerEntity;
import com.chanel.fsh.peps.nextgen.cms.domain.models.CMSContainer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CMSContainerEntityMapper {
    CMSContainer toModel(CMSContainerEntity cmsContainerEntity);
}
