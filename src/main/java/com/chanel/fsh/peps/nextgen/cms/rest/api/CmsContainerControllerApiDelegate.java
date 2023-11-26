package com.chanel.fsh.peps.nextgen.cms.rest.api;

import com.chanel.fsh.peps.nextgen.cms.rest.dto.CMSContainerDTO;
import org.springframework.http.ResponseEntity;

public interface CmsContainerControllerApiDelegate {
    ResponseEntity<CMSContainerDTO> cMSGetCmsContainerByLabel(String pageLabel);
}
