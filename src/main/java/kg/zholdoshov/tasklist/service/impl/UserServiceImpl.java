package kg.zholdoshov.tasklist.service.impl;

import kg.zholdoshov.tasklist.domain.user.User;
import kg.zholdoshov.tasklist.repository.UserRepository;
import kg.zholdoshov.tasklist.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(null);
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public boolean isTaskOwner(Long userId, Long taskId) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }
}
