package martin.dev.sweethair.controllers;

import lombok.AllArgsConstructor;
import martin.dev.sweethair.dtos.UserDtoPost;
import martin.dev.sweethair.dtos.base.UserDtoBase;
import martin.dev.sweethair.dtos.full.UserDtoFull;
import martin.dev.sweethair.entities.User;
import martin.dev.sweethair.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<List<UserDtoFull>> getAll() {
        List<UserDtoFull> users = userService.getAll().stream()
                .map(user -> modelMapper.map(user, UserDtoFull.class)).collect(Collectors.toList());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDtoBase> create(@RequestBody UserDtoPost userDtoPost) {
        User user = userService.save(userDtoPost);
        UserDtoBase userDtoBase = modelMapper.map(user, UserDtoBase.class);
        return new ResponseEntity<>(userDtoBase, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoFull> getById(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        UserDtoFull userDtoFull = modelMapper.map(user, UserDtoFull.class);
        return new ResponseEntity<>(userDtoFull, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDtoFull> updateById(@RequestBody UserDtoPost userDtoPost) {
        User user = userService.updateById(userDtoPost);
        UserDtoFull userDtoFull = modelMapper.map(user, UserDtoFull.class);
        return new ResponseEntity<>(userDtoFull, HttpStatus.OK);
    }
}
