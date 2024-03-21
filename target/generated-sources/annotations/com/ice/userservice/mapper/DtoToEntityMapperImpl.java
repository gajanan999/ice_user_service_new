package com.ice.userservice.mapper;

import com.ice.userservice.dto.UserDto;
import com.ice.userservice.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-21T13:44:55+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class DtoToEntityMapperImpl implements DtoToEntityMapper {

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUserName( userDto.getUserName() );
        user.setPassword( userDto.getPassword() );
        user.setRole( userDto.getRole() );
        user.setEmailId( userDto.getEmailId() );
        user.setMobileNumber( userDto.getMobileNumber() );

        return user;
    }

    @Override
    public List<User> userDtosToUsers(List<UserDto> userDtos) {
        if ( userDtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDtos.size() );
        for ( UserDto userDto : userDtos ) {
            list.add( userDtoToUser( userDto ) );
        }

        return list;
    }
}
