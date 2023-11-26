package com.chanel.fsh.peps.nextgen.cms.domain.services.impl;

import com.chanel.fsh.peps.nextgen.cms.domain.models.CMSContainer;
import com.chanel.fsh.peps.nextgen.cms.domain.daos.CMSContainerDao;
import com.chanel.fsh.peps.nextgen.cms.domain.models.Product;
import com.chanel.fsh.peps.nextgen.cms.domain.services.CMSContainerService;
import org.springframework.stereotype.Service;

@Service
public class CMSContainerServiceImpl implements CMSContainerService {

    private CMSContainerDao cmsContainerPort;


    public CMSContainer getByLabel(String pageLabel) {
        return cmsContainerPort.getByLabel(pageLabel);
    }

    @Override
    public void processProductEvent(Product product) {
        System.out.println("Print from Service => " + product.getTest());
    }


    public CMSContainerServiceImpl(CMSContainerDao cmsContainerPort) {
        this.cmsContainerPort = cmsContainerPort;
    }
}
