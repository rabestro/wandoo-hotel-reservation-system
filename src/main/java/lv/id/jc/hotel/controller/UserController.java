package lv.id.jc.hotel.controller;

import lv.id.jc.hotel.model.User;
import lv.id.jc.hotel.model.dto.Credentials;
import lv.id.jc.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Registration of new employees of the hotel.
 * This request is available only to registered employees of the hotel.
 */
@RepositoryRestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("users")
    @Secured("ROLE_EMPLOYEE")
    public @ResponseBody ResponseEntity<?> register(@RequestBody @Valid Credentials credentials) {
        userService.createUser(credentials, User.Role.EMPLOYEE);
        return ResponseEntity.ok(null);
    }

}
