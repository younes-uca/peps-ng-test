package com.chanel.fsh.peps.nextgen.cms.util.security.ws;


import com.chanel.fsh.peps.nextgen.cms.util.security.bean.Role;
import com.chanel.fsh.peps.nextgen.cms.util.security.service.facade.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/roles")
@RestController
public class RoleRest {
    private RoleService roleService;

    @GetMapping("/")
    public List<Role> findAll() {
        return this.roleService.findAll();
    }

    public RoleRest(RoleService roleService) {
        this.roleService = roleService;
    }
}
