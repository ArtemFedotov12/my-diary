package com.start.diary.entities;

import org.springframework.security.core.GrantedAuthority;

//we implements because in clas User we implements UserDetails
// and implements methods see 4 video -1.10
public enum Role implements GrantedAuthority {
    SCHOOLKID,
    ADMIN,
    DIRECTOR,
    PARENT,
    TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
