package kg.zholdoshov.tasklist.web.mappers;

import kg.zholdoshov.tasklist.domain.task.TaskImage;
import kg.zholdoshov.tasklist.web.dto.task.TaskImageDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskImageMapper extends Mappable<TaskImage, TaskImageDto> {


}
