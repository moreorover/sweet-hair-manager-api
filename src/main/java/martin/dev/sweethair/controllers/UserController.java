package martin.dev.sweethair.controllers;

import lombok.AllArgsConstructor;
import martin.dev.sweethair.dtos.PostUserDto;
import martin.dev.sweethair.entities.User;
import martin.dev.sweethair.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody PostUserDto postUserDto) {
        User user = userService.save(postUserDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateById(@RequestBody PostUserDto postUserDto) {
        User user = userService.updateById(postUserDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
