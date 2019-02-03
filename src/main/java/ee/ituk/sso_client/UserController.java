package ee.ituk.sso_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final LoggedInUserService loggedInUserService;

    @Autowired
    public UserController(LoggedInUserService loggedInUserService) {
        this.loggedInUserService = loggedInUserService;
    }

    @GetMapping("/user")
    public String getLoggedInUsername() {
        return loggedInUserService.getLoggedInUsername();
    }


}
