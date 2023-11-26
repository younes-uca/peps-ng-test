package com.chanel.fsh.peps.nextgen.cms.domain.daos;

import com.chanel.fsh.peps.nextgen.cms.domain.models.CMSContainer;

public interface CMSContainerDao {

    CMSContainer getByLabel(String pageLabel);
}
