package de.stuttgart.syzl.controller;

import de.stuttgart.syzl.entity.User;
import de.stuttgart.syzl.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(tags = "Controller methods for managing Users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    @ApiOperation(value = "Get user details by userId")
    public String getUser(@PathVariable int userId) {

        return "Hello";
    }

    @PutMapping("/users")
    @ApiOperation(value = "Register a new user")
    public String addUser(@RequestBody User user) {

        return "Hello";
    }

    @PatchMapping("/users")
    @ApiOperation(value = "Update user")
    public String updateUser(@RequestBody User user) {

        return "Hello";
    }

    @DeleteMapping("/users/{userId}")
    @ApiOperation(value = "Delete user")
    public String deleteUser(@PathVariable int userId) {

        return "Hello";
    }

    @PutMapping("/users/{userId}/newFriend/{friendId}")
    @ApiOperation(value = "Add a new friend to a specific user (connect to users)")
    public String addUser(@PathVariable int userId, @PathVariable int friendId) {

        return "Hello";
    }

    @GetMapping("/users/{userName}")
    @ApiOperation(value = "Search and return a specific user")
    public String searchUser(@PathVariable String userName) {

        return "Hello";
    }

    @GetMapping("/users/{userId}/streamingServices")
    @ApiOperation(value = "Return all streaming services for specific user")
    public String getStreamingServices(@PathVariable int userId) {

        return "Hello";
    }

    @PutMapping("/users/{userId}/streamingServices/{streamingName}")
    @ApiOperation(value = "Return all liked movies for specific user")
    public String addStreamingServices(@PathVariable int userId, @PathVariable String streamingName) {

        return "Hello";
    }

    @DeleteMapping("/users/{userId}/streamingServices/{streamingName}")
    @ApiOperation(value = "Return all liked movies for specific user")
    public String removeStreamingServices(@PathVariable int userId, @PathVariable String streamingName) {

        return "Hello";
    }


}
