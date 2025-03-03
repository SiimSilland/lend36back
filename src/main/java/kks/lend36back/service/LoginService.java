package kks.lend36back.service;

import kks.lend36back.controller.login.dto.LoginResponse;
import kks.lend36back.infrastructure.exception.ForbiddenException;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserMapper;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static kks.lend36back.infrastructure.Error.INCORRECT_CREDENTIALS;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public LoginResponse login(String email, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(email, password, Status.ACTIVE.getCode());
        User user = optionalUser.orElseThrow(() -> new ForbiddenException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode()));
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;

    }
}
