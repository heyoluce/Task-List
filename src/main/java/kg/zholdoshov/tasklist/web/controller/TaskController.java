package kg.zholdoshov.tasklist.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.zholdoshov.tasklist.domain.task.Task;
import kg.zholdoshov.tasklist.domain.task.TaskImage;
import kg.zholdoshov.tasklist.service.TaskService;
import kg.zholdoshov.tasklist.web.dto.task.TaskDto;
import kg.zholdoshov.tasklist.web.dto.task.TaskImageDto;
import kg.zholdoshov.tasklist.web.dto.validation.OnUpdate;
import kg.zholdoshov.tasklist.web.mappers.TaskImageMapper;
import kg.zholdoshov.tasklist.web.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Validated
@Tag(name = "Task Controller", description = "Task API")
public class TaskController {
    private final TaskService taskService;

    private final TaskMapper taskMapper;

    private final TaskImageMapper taskImageMapper;

    @PutMapping
    @Operation(summary = "Update task")
    @PreAuthorize("@customSecurityExpression.canAccessTask(#taskDto.id)")
    public TaskDto update(final @Validated(OnUpdate.class)
                              @RequestBody TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task updatedTask = taskService.update(task);
        return taskMapper.toDto(updatedTask);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get task by id")
    @PreAuthorize("@customSecurityExpression.canAccessTask(#id)")
    public TaskDto getById(final @PathVariable("id") Long id) {
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }


    @DeleteMapping("/{taskId}")
    @Operation(summary = "Delete task")
    @PreAuthorize("@customSecurityExpression.canAccessTask(#id)")
    public void deleteById(final @PathVariable("taskId") Long id) {
        taskService.delete(id);
    }

    @PostMapping("/{id}/image")
    @Operation(summary = "Upload image to task")
    @PreAuthorize("@customSecurityExpression.canAccessTask(#id)")
    public void uploadImage(final @PathVariable Long id,
                            final @Validated @ModelAttribute
                            TaskImageDto imageDto) {
        TaskImage image = taskImageMapper.toEntity(imageDto);
        taskService.uploadImage(id, image);
    }

}
