package com.chanel.fsh.peps.nextgen.cms.db.daos;

import com.chanel.fsh.peps.nextgen.cms.db.repositories.CMSContainerRepository;
import com.chanel.fsh.peps.nextgen.cms.db.mappers.CMSContainerEntityMapper;
import com.chanel.fsh.peps.nextgen.cms.db.entities.CMSContainerEntity;
import com.chanel.fsh.peps.nextgen.cms.domain.daos.CMSContainerDao;
import com.chanel.fsh.peps.nextgen.cms.domain.models.CMSContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CMSContainerDaoImpl implements CMSContainerDao {

    private CMSContainerRepository cmsContainerRepository;

    private CMSContainerEntityMapper cmsContainerEntityConverter;

    public CMSContainer getByLabel(String pageLabel){
        CMSContainerEntity cmsContainerEntity = cmsContainerRepository.findByName(pageLabel);
        if(cmsContainerEntity != null) {
            return cmsContainerEntityConverter.toModel(cmsContainerEntity);
        }
        return null;
    }

    public CMSContainerDaoImpl(CMSContainerRepository cmsContainerRepository, CMSContainerEntityMapper cmsContainerEntityConverter) {
        this.cmsContainerRepository = cmsContainerRepository;
        this.cmsContainerEntityConverter = cmsContainerEntityConverter;
    }
}
