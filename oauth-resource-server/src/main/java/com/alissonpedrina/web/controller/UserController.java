package com.alissonpedrina.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alissonpedrina.service.UserService;
import com.alissonpedrina.web.dto.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

    public UserController() {
        super();
    }

    @PreAuthorize("#oauth2.hasScope('userbuild') and #oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/user")
    @ResponseBody
    public Principal findBuildingByUserId(Principal principal) {
        return principal;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<User> getAllUsers() {
    	
    	return userService.getAll();
    }

    //@PreAuthorize("#oauth2.hasScope('userbuild') and #oauth2.hasScope('write') and hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User createUser(@RequestBody final User user) {
    	
    	user.setId(String.valueOf(userService.create(user)));
        
        return user;
    }
    
    //@PreAuthorize("#oauth2.hasScope('userbuild') and #oauth2.hasScope('write') and hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User updateUser(@RequestBody final User user) {
       
    	userService.update(user);
    	
        return user;
    }
}
