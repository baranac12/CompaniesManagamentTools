package com.bca.cmt.mapper;


import com.bca.cmt.dto.UserResponse;
import com.bca.cmt.model.user.User;

public class UserMapper {

        public static UserResponse toUserList(User entity) {
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
