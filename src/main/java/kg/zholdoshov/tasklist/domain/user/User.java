package kg.zholdoshov.tasklist.domain.user;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import kg.zholdoshov.tasklist.domain.task.Task;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String password;

    private String passwordConfirmation;

    private Set<Role> roles;

    private List<Task> tasks;

}
