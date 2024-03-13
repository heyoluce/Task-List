package kg.zholdoshov.tasklist.web.mappers;

import kg.zholdoshov.tasklist.domain.user.User;
import kg.zholdoshov.tasklist.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {

}
