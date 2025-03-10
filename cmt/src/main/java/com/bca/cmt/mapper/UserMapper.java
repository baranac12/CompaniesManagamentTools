package com.bca.cmt.mapper;


import com.bca.cmt.dto.UserResponse;
import com.bca.cmt.model.user.Users;

public class UserMapper {

        public static UserResponse toUserList(Users entity) {
            return new UserResponse(
                    entity.getId(),
                    entity.getName(),
                    entity.getSurname(),
                    entity.getUsername(),
                    entity.getEmail(),
                    entity.getDepartment().getName()
            );
        }


}
