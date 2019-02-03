package ee.ituk.SsoTestClient;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoggedInUserService {

    String getLoggedInUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken))  {
            if (auth.isAuthenticated()) {
                Object principal = auth.getPrincipal();
                if (principal instanceof String && ((String) principal).length() > 0) {
                    return (String) principal;
                }
            }
        }
        return null;
    }

}
