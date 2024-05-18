package siemens.booking.services;

import siemens.booking.entity.User;

public interface UserService {
    User save(User user);
    void updateUserLocation();

    User getUser(Long userId);
}
