package kg.zholdoshov.tasklist.service;

import kg.zholdoshov.tasklist.domain.task.Task;
import kg.zholdoshov.tasklist.domain.task.TaskImage;

import java.util.List;

public interface TaskService {

    Task getById(Long id);

    List<Task> getAllByUserId(Long id);

    Task update(Task task);

    Task create(Task task, Long id);

    void delete(Long id);

    void uploadImage(Long id, TaskImage image);
}
