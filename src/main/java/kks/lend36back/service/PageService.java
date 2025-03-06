package kks.lend36back.service;

import jakarta.validation.constraints.NotNull;
import kks.lend36back.controller.student.dto.NewCv;
import kks.lend36back.infrastructure.Error;
import kks.lend36back.infrastructure.exception.ForbiddenException;
import kks.lend36back.persistence.cv.Cv;
import kks.lend36back.persistence.cv.CvMapper;
import kks.lend36back.persistence.cv.CvRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PageService {

    private final CvRepository cvRepository;
    private final CvMapper cvMapper;
    private final UserRepository userRepository;

    public void addCv (NewCv newCv){
        Optional<User> optionalUser = userRepository.findById(newCv.getUser());
        @NotNull byte[] cvData = newCv.getData();

        //        .orElseThrow(() -> new RuntimeException("User not found"));

        Cv cvEntity = cvMapper.toEntity(newCv);

        //@NotNull byte[] bytes = newCv.getData();
        //Cv cv = cvMapper.toEntity(bytes);
        //User user = new User();
        //user.setId(cv.getId());
        cvRepository.save(cvEntity);

    }

}
