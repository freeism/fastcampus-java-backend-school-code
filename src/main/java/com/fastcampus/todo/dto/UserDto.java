package com.fastcampus.todo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Martin
 * @since 2020/12/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotEmpty // null == str && "" == str
    private String name;
    @Email
    private String email;
    @NotEmpty
    private String city;
    @NotEmpty
    private String province;
    @NotEmpty
    private String password;
}
