package kg.zholdoshov.tasklist.web.controller;

import kg.zholdoshov.tasklist.domain.task.Task;
import kg.zholdoshov.tasklist.service.TaskService;
import kg.zholdoshov.tasklist.web.dto.task.TaskDto;
import kg.zholdoshov.tasklist.web.dto.validation.OnUpdate;
import kg.zholdoshov.tasklist.web.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Validated
public class TaskController {
    private final TaskService taskService;

    private final TaskMapper taskMapper;

    @PutMapping
    public TaskDto update(@Validated(OnUpdate.class)
                              @RequestBody TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task updatedTask = taskService.update(task);
        return taskMapper.toDto(updatedTask);
    }


    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable("id") Long id) {
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        taskService.delete(id);
    }
}