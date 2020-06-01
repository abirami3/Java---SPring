
package com.aspiresys.restsample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aspiresys.restsample.model.User;
import com.aspiresys.restsample.service.UserInterface;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
	
	@Autowired 
	UserInterface userService;

	//If we give "required = false" for integer requestparam it will throw the error
	@GetMapping
	public ResponseEntity getUsers(@RequestParam(value = "page", defaultValue = "10" ,required = false) int page, @RequestParam(value = "limit", required = false) int limit) {
		
		
		Map<Integer, User> map = new HashMap<>();
		
		map = userService.getUsers();
		//User user = new User("Abirami", "Murugesan","abirami.murugesan@aspiresys.com",1);
		 
		return new ResponseEntity(map,HttpStatus.OK);
		
	}

	@GetMapping(path = "/{userId}"
			//,produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity getUser(@PathVariable String userId) {
		
		Map<Integer, User> map = new HashMap<>();
		
		userService.getUsers();
		//User user = new User("Abirami", "Murugesan","abirami.murugesan@aspiresys.com",1);
		 
		return new ResponseEntity(map,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		System.out.println(user.getFirstName());
		userService.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		
		user.setFirstName("Abi");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping
	public String deleteUser() throws Throwable {
		//throw new Exception();
		
		return "User Deleted Successfully";
	}
}
