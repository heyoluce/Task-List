package kg.zholdoshov.tasklist.web.mappers;

import kg.zholdoshov.tasklist.web.dto.task.TaskDto;
import kg.zholdoshov.tasklist.domain.task.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    List<TaskDto> toDto(List<Task> tasks);

    Task toEntity(TaskDto dto);
}
