package kg.zholdoshov.tasklist.web.mappers;

import kg.zholdoshov.tasklist.domain.task.Task;
import kg.zholdoshov.tasklist.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper extends Mappable<Task, TaskDto> {


}
