package kg.zholdoshov.tasklist.repository;

import kg.zholdoshov.tasklist.domain.user.Role;
import kg.zholdoshov.tasklist.domain.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    void update(User user);
    void create(User user);

    void delete(Long id);
    void insertUserRole(Long userId, Role role);

    boolean isTaskOwner(Long userId, Long taskId);

}
