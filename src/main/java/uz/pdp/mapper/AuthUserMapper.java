package uz.pdp.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.dto.authUser.AuthUserCreateDto;
import uz.pdp.entity.AuthUser;



@Component
@Mapper(componentModel="spring")
public interface AuthUserMapper {




    AuthUser fromCreateDto(AuthUserCreateDto dto);



}
