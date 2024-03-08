package kg.zholdoshov.tasklist.service.impl;

import kg.zholdoshov.tasklist.domain.exception.ResourceNotFoundException;
import kg.zholdoshov.tasklist.domain.task.Status;
import kg.zholdoshov.tasklist.domain.task.Task;
import kg.zholdoshov.tasklist.domain.user.User;
import kg.zholdoshov.tasklist.repository.TaskRepository;
import kg.zholdoshov.tasklist.service.TaskService;
import kg.zholdoshov.tasklist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "TaskService::getById", key = "#id")
    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAllByUserId(Long userId) {
        return taskRepository.findAllByUserId(userId);
    }

    @Override
    @CachePut(value = "TaskService::getById", key = "#task.id")
    public Task update(Task task) {
        if (task.getStatus() == null) {
            task.setStatus(Status.TODO);
        }
        taskRepository.save(task);
        return task;
    }

    @Override
    @Cacheable(value = "TaskService::getById", key = "#task.id")
    public Task create(Task task, Long userId) {
        User user = userService.getById(userId);

        task.setStatus(Status.TODO);
        user.getTasks().add(task);
        userService.update(user);
        return task;
    }

    @Override
    @CacheEvict(value = "TaskService::getById", key = "#id")
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
