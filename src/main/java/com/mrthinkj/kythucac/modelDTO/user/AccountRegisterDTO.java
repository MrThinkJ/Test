package com.mrthinkj.kythucac.modelDTO.user;

import com.mrthinkj.kythucac.annotation.PasswordMatches;
import com.mrthinkj.kythucac.annotation.ValidEmail;
import com.mrthinkj.kythucac.annotation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class AccountRegisterDTO {
    @NotNull(message = "Không được để trống thông tin")
    @NotEmpty(message = "Không được để trống thông tin")
    @Size(min = 6, message = "Tên đăng nhập ít nhất 6 kí tự")
    @Size(max = 10, message = "Tên đăng nhập nhiều nhất 10 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Tên đăng nhập không được chứa kí tự đặc biệt hoặc khoảng trắng")
    private String username;

    @NotNull(message = "Không được để trống thông tin")
    @NotEmpty(message = "Không được để trống thông tin")
    @Size(min = 6, message = "Mật khẩu ít nhất 6 kí tự")
    @Size(max = 20, message = "Mật khẩu nhiều nhất 20 kí tự")
    @ValidPassword
    private String password;
    private String matchingPassword;

    @NotNull(message = "Không được để trống thông tin")
    @NotEmpty(message = "Không được để trống thông tin")
    @ValidEmail
    private String email;
}
