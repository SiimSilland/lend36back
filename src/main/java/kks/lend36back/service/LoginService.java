package kks.lend36back.service;

import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;


    public void login(String email, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(email, password, Status.ACTIVE.getCode());
        User user = optionalUser.orElseThrow(() -> new )

    }
}
