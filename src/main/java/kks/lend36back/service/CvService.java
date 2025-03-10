package kks.lend36back.service;

import kks.lend36back.controller.cv.dto.CvDto;
import kks.lend36back.persistence.cv.Cv;
import kks.lend36back.persistence.cv.CvRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.util.BytesConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CvService {

    private final CvRepository cvRepository;
    private final UserRepository userRepository;
    private final BytesConverter bytesConverter;


    public void addCV(CvDto cvDto) {


        User userById = userRepository.findUserById(cvDto.getUserId());

        Cv cv = new Cv();


        cv.setUser(userById);


        byte[] bytes = bytesConverter.stringToBytesArray(cvDto.getCvData());

        // todo: siis saame selle CV objektile külge panna
        // todo: seejärel saame CV objekti adnmebaasi maha salvestada
        cv.setData(bytes);
        cvRepository.save(cv);

    }
}