package siemens.booking.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.entity.User;
import siemens.booking.repository.UserRepository;
import siemens.booking.services.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public void updateUserLocation() {

    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
