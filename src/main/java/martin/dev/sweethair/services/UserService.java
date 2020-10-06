package martin.dev.sweethair.services;

import lombok.AllArgsConstructor;
import martin.dev.sweethair.dtos.PostUserDto;
import martin.dev.sweethair.entities.User;
import martin.dev.sweethair.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User save(PostUserDto postUserDto) {
        return userRepository.save(
                User.builder()
                        .firstName(postUserDto.getFirstName())
                        .lastName(postUserDto.getLastName())
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

    public User updateById(PostUserDto postUserDto) {
        User user = userRepository.getById(postUserDto.getId());

        user.setFirstName(postUserDto.getFirstName());
        user.setLastName(postUserDto.getLastName());
        userRepository.save(user);
        return user;
    }
}
