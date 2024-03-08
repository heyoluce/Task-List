package kg.zholdoshov.tasklist.domain.user;

import jakarta.persistence.*;
import kg.zholdoshov.tasklist.domain.task.Task;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String username;
    private String password;

    @Transient
    private String passwordConfirmation;

    @Column(name = "role")
    @ElementCollection
    @CollectionTable(name = "users_roles")
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;

    @OneToMany
    @JoinTable(name = "users_tasks", inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;
}
