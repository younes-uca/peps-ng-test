package com.chanel.fsh.peps.nextgen.cms.util.security.service.impl;

import com.chanel.fsh.peps.nextgen.cms.util.security.bean.Permission;
import com.chanel.fsh.peps.nextgen.cms.util.security.dao.PermissionDao;
import com.chanel.fsh.peps.nextgen.cms.util.security.service.facade.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    private PermissionDao permissionDao;

    @Override
    public Permission save(Permission permission) {
        Permission perm = permissionDao.findByName(permission.getName());
        return perm == null ? permissionDao.save(permission) : perm;
    }

    public PermissionServiceImpl(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }
}
