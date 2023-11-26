package com.chanel.fsh.peps.nextgen.cms.util.security.ws;


import com.chanel.fsh.peps.nextgen.cms.util.security.bean.User;
import com.chanel.fsh.peps.nextgen.cms.util.security.common.SecurityParams;
import com.chanel.fsh.peps.nextgen.cms.util.security.dao.RoleDao;
import com.chanel.fsh.peps.nextgen.cms.util.security.dao.UserDao;
import com.chanel.fsh.peps.nextgen.cms.util.security.jwt.JwtUtils;
import com.chanel.fsh.peps.nextgen.cms.util.security.payload.request.LoginRequest;
import com.chanel.fsh.peps.nextgen.cms.util.security.payload.response.JwtResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserDao userRepository;
    private RoleDao roleRepository;
    private PasswordEncoder encoder;
    private JwtUtils jwtUtils;

    @PostMapping("login")
    public ResponseEntity authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        HttpHeaders headers = new HttpHeaders();
        headers.add(SecurityParams.JWT_HEADER_NAME, SecurityParams.HEADER_PREFIX + jwt);
        return ResponseEntity.ok()
                .headers(headers)
                .body(new JwtResponse(jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles));
    }

    public AuthController(AuthenticationManager authenticationManager, UserDao userRepository, RoleDao roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }
}
