package de.stuttgart.syzl.controller;

import de.stuttgart.syzl.service.CircleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(tags = "Controller methods for managing Circles")
public class CircleController {

    @Autowired
    private CircleService circleService;

    @GetMapping("/users/{userId}/circles")
    @ApiOperation(value = "Return all circles for specific user")
    public String getCircles(@PathVariable Long userId) {

        return "Hello";
    }

    @PutMapping("/users/{userId}/circles/{name}")
    @ApiOperation(value = "Add new circles for specific user")
    public String addCircle(@PathVariable Long userId, @PathVariable String name) {

        return "Hello";
    }

    @PatchMapping ("/users/{userId}/circles/{circleId}/{newName}")
    @ApiOperation(value = "Update the name of a circle")
    public String updateCircle(@PathVariable Long userId, @PathVariable Long circleId, @PathVariable String newName) {

        return "Hello";
    }

    @DeleteMapping("/users/{userId}/circles/{circleId}")
    @ApiOperation(value = "delete circle for specific user")
    public String deleteCircle(@PathVariable Long userId, @PathVariable Long circleId) {

        return "Hello";
    }

    @GetMapping("/users/{userId}/circles/{circleId}/users")
    @ApiOperation(value = "Return all users of one circle")
    public String getCircleUsers(@PathVariable Long userId, @PathVariable Long circleId) {

        return "Hello";
    }

    @GetMapping("/users/{userId}/circles/{circleId}/matches")
    @ApiOperation(value = "Return all matches of one circle")
    public String getCircleMatches(@PathVariable Long userId, @PathVariable Long circleId) {

        return "Hello";
    }

    @DeleteMapping("/users/{userId}/circles/{circleId}/matches/{movieTitle}")
    @ApiOperation(value = "Delete one movie from the matches of one circle")
    public String removeCircleMatch(@PathVariable Long userId, @PathVariable Long circleId, @PathVariable String movieTitle) {

        return "Hello";
    }

    @PutMapping("/users/{userId}/circles/{circleId}/addUser/{newUserId}")
    @ApiOperation(value = "Add a user to an existing circle")
    public String addUserToCircle(@PathVariable Long userId, @PathVariable Long circleId, @PathVariable Long newUserId) {

        return "Hello";
    }

    @DeleteMapping("/users/{userId}/circles/{circleId}/addUser/{newUserId}")
    @ApiOperation(value = "Remove user from circle")
    public String removeUserFromCircle(@PathVariable Long userId, @PathVariable Long circleId, @PathVariable Long newUserId) {

        return "Hello";
    }
    
    

}
