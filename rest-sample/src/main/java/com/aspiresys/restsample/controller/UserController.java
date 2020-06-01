
package com.aspiresys.restsample.controller;

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

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	//If we give "required = false" for integer requestparam it will throw the error
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "10" ,required = false) int page, @RequestParam(value = "limit") int limit) {
		return "Users details page is  " + page + " and the limit is "+ limit;
	}

	@GetMapping(path = "/{userId}"
			//,produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		
		User user = new User("Abirami", "Murugesan","abirami.murugesan@aspiresys.com",1);
		 
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		
		user.setFirstName("Abi");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping
	public String deleteUser() throws Throwable {
		throw new Exception();
	}
}
