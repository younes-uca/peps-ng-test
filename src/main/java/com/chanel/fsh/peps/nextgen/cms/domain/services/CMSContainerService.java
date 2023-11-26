package com.chanel.fsh.peps.nextgen.cms.domain.services;

import com.chanel.fsh.peps.nextgen.cms.domain.models.CMSContainer;
import com.chanel.fsh.peps.nextgen.cms.domain.models.Product;

public interface CMSContainerService {
    CMSContainer getByLabel(String pageLabel);

    void processProductEvent(Product product);
}
