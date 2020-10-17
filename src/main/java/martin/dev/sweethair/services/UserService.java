package martin.dev.sweethair.services;

import lombok.AllArgsConstructor;
import martin.dev.sweethair.dtos.UserDtoPost;
import martin.dev.sweethair.entities.User;
import martin.dev.sweethair.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User save(UserDtoPost userDtoPost) {
        return userRepository.save(
                User.builder()
                        .firstName(userDtoPost.getFirstName())
                        .lastName(userDtoPost.getLastName())
                        .build());
    }

    public User getById(Long id) {
        return userRepository.getById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateById(UserDtoPost userDtoPost) {
        User user = userRepository.getById(userDtoPost.getId());

        user.setFirstName(userDtoPost.getFirstName());
        user.setLastName(userDtoPost.getLastName());
        userRepository.save(user);
        return user;
    }
}
