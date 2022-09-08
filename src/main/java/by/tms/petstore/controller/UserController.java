package by.tms.petstore.controller;

import by.tms.petstore.entity.User;
import by.tms.petstore.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Tag(name = "user", description = "Operation about user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation(summary = "Create User", description = "This can only be done by the logged in user", responses = @ApiResponse(responseCode = "default", description = "\t\n" +
            "successful operation"))
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User save = userService.save(user);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PostMapping("/createWithList")
    @Operation(summary = "Create list of users with given input array", responses =@ApiResponse(responseCode = "default", description = "successful operation"))
    public ResponseEntity<List<User>> createWithList(@RequestBody @Valid List<User> users) {
        List<User> users1 = userService.saveList(users);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    @Operation(summary = "Get User by user name", description = "The name that needs to be fetched. Use user1 for testing.")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        Optional<User> byUsername = userService.findByUsername(username);
        if (byUsername.isPresent()) {
            return ResponseEntity.ok(byUsername.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{username}")
    @Operation(summary = "Updated user", description = "This can only be done by the logged in user.")
    public ResponseEntity<User> updateByUsername(@PathVariable String username, @RequestBody @Valid User user) {
        Optional<User> user1 = userService.updateByUsername(username, user);
        if (user1.isPresent()) {
            return ResponseEntity.ok(user1.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{username}")
    @Operation(summary = "Delete User", description = "This can only be done by the logged in user.")
    public ResponseEntity<User> deleteUser(@PathVariable String username) {
        Optional<User> user = userService.deleteUser(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }
}
