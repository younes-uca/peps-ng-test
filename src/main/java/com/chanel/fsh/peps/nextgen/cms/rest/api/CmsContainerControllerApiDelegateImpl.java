package com.chanel.fsh.peps.nextgen.cms.rest.api;

import com.chanel.fsh.peps.nextgen.cms.domain.models.CMSContainer;
import com.chanel.fsh.peps.nextgen.cms.domain.services.CMSContainerService;
import com.chanel.fsh.peps.nextgen.cms.rest.dto.CMSContainerDTO;
import com.chanel.fsh.peps.nextgen.cms.rest.mappers.CMSContainerDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CmsContainerControllerApiDelegateImpl implements CmsContainerControllerApiDelegate {

    private CMSContainerService cmsContainerService;

    private CMSContainerDTOMapper cmsContainerMapper;

    @Override
    public ResponseEntity<CMSContainerDTO> cMSGetCmsContainerByLabel(String pageLabel) {
        CMSContainer cmsContainer = cmsContainerService.getByLabel(pageLabel);
        if(cmsContainer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cmsContainerMapper.toDto(cmsContainer));
    }

    public CmsContainerControllerApiDelegateImpl(CMSContainerService cmsContainerService, CMSContainerDTOMapper cmsContainerMapper) {
        this.cmsContainerService = cmsContainerService;
        this.cmsContainerMapper = cmsContainerMapper;
    }
}
