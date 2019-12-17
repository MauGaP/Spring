package com.mpedano.spring.controller;

import com.mpedano.spring.model.User;
import com.mpedano.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity getUsers() {
        List<User> list = userService.listAllUsers();
        return ResponseEntity
                .ok()
                .header("myheader", "myvalue")
                .body(list);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity getUser(@PathVariable("id") int id) {
        Optional<User> user = userService.findUserById(id);
        return ResponseEntity
                .ok()
                .header("myHeader", "myValue")
                .body(user);
    }

    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

    @PutMapping(value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @GetMapping(value = "/{firstName}/listByFirstName/")
    public ResponseEntity getUsersByFirstName(@PathVariable("firstName") String firstName) {
        List<User> list = userService.getUsersByFirstName(firstName);
        return ResponseEntity
                .ok()
                .header("myHeader", "myValue")
                .body(list);
    }

    @GetMapping(value = "/{lastName}/listByLastName/")
    public ResponseEntity findByLastName(@PathVariable("lastName") String lastName) {
        List<User> list = userService.getUsersByLastName(lastName);
        return ResponseEntity
                .ok()
                .header("myHeader", "myValue")
                .body(list);
    }
}
