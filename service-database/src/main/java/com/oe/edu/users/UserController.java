package com.oe.edu.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oe.edu.dao.user.UserEntity;
import com.oe.edu.dao.user.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/test")
	public String test() {
		return "this is test";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public UserEntity Login(@RequestBody UserEntity user) {
		return userService.Login(user);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login/{id}")
	public UserEntity getUser(@PathVariable String id) {
		return userService.getUser(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/login/{id}")
	public UserEntity updateUser(@RequestBody UserEntity user, @PathVariable String id) {
		return userService.UpdateUser(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/login/{id}")
	public boolean deleteUser(@PathVariable String id) {
		return userService.deleteUser(id);
	}

	@RequestMapping("/all")
	public ArrayList<UserEntity> getAllUser() {
		return (ArrayList<UserEntity>)userService.queryAll();
	}


	@RequestMapping(method = RequestMethod.POST, value = "/login/{id}", produces="application/json")
	public UserEntity saveData(@PathVariable String id,HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
//        request.getHeader("Accept");
//        System.out.println(request.getHeader("Accept"));
////      response.setContentType("application/json");
//        String username = request.getParameter("username");
//        System.out.println("testMethod..."+username);
//        model.addAttribute("user", username);
//        Object jsonString =  "{'name': 'helloworlda'}";
//        JSONObject jsonobj=JSONObject.fromObject(jsonString);
//        PrintWriter out = response.getWriter();
//        out.print(jsonobj);
        
        return null;
    }
	
}
