package kks.lend36back.service;

import jakarta.validation.constraints.NotNull;
import kks.lend36back.controller.student.dto.NewCv;
import kks.lend36back.infrastructure.Error;
import kks.lend36back.persistence.cv.Cv;
import kks.lend36back.persistence.cv.CvMapper;
import kks.lend36back.persistence.cv.CvRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static kks.lend36back.infrastructure.Error.FOREIGN_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PageService {

    private final CvRepository cvRepository;
    private final CvMapper cvMapper;
    private final UserRepository userRepository;


    public String addCV (Cv cv){

        Optional<User> user = userRepository.findById(cv.getId())
                .orElseThrow(() -> FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode());


    }

    /*
    public void addCv(NewCv newCv) {
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

     */


