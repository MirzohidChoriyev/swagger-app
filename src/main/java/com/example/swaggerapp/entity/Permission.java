package com.example.swaggerapp.entity;

import com.example.swaggerapp.enums.PermissionName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
public class Permission implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private PermissionName permissionName;

    @Override
    public String getAuthority() {
        return permissionName.name();
    }
}
