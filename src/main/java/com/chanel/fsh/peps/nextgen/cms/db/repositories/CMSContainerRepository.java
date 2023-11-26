package com.chanel.fsh.peps.nextgen.cms.db.repositories;

import com.chanel.fsh.peps.nextgen.cms.db.entities.CMSContainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CMSContainerRepository extends JpaRepository<CMSContainerEntity, Integer> {
    CMSContainerEntity findByName(String name);
}
