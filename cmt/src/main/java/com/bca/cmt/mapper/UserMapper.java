package com.bca.cmt.mapper;


import com.bca.cmt.dto.UserDto;
import com.bca.cmt.model.user.User;

public class UserMapper {

        public static UserDto toUserList(User entity) {
            return new UserDto(
                    entity.getId(),
                    entity.getName(),
                    entity.getSurname(),
                    entity.getUsername(),
                    entity.getEmail(),
                    entity.getDepartment().getName()
            );
        }


}
