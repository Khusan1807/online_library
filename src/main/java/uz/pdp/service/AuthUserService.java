package uz.pdp.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.dto.authUser.AuthUserCreateDto;
import uz.pdp.dto.authUser.AuthUserDto;
import uz.pdp.entity.AuthUser;
import uz.pdp.enums.Role;
import uz.pdp.mapper.AuthUserMapper;
import uz.pdp.repository.AuthUserRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthUserService {

    private final AuthUserMapper mapper;
    private final PasswordEncoder encoder;
    private final AuthUserRepository repository;



    public void create(AuthUserCreateDto createDto) {
        AuthUser user = mapper.fromCreateDto(createDto);
        user.setUsername(createDto.getUsername());
        user.setPassword(encoder.encode(createDto.getPassword()));
        repository.save(user);
    }

    public void login(AuthUserDto dto) {
        Optional<AuthUser> authUser = repository.findAuthUserByUsername(dto.getUsername());
        if (authUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        if (!encoder.matches(dto.getPassword(), authUser.get().getPassword())) {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
