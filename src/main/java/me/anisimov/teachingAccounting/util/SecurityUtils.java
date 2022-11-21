package me.anisimov.teachingAccounting.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static String getCurrentUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated())
            return authentication.getName();
       throw new RuntimeException("Not authenticated");
    }
}
