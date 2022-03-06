package uz.pdp.dto.authUser;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.enums.Role;


@Setter
@Getter
public class AuthUserUpdateDto {

    private Long id;
    private String username;
    private String password;
    private Role role;

}
