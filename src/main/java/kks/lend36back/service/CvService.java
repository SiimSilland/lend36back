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
        // todo: userId on meil foreign key
        // todo: JPA tehnoloogia mõistes tähendab see seda, et me peame selle userId abil repository kaudu leidma ülesse User objekti

        User userById = userRepository.findUserById(cvDto.getUserId());
        // todo: Pole pointi hakata uut Cv objekti (rida) mapperiga tegema
        // todo: Mõistlik ise see objekt luua
        Cv cv = new Cv();

        // todo: Kui uus CV objetk on olemas
        // todo: siis panna kohe talle külge tema foreign key object User
        cv.setUser(userById);

        // todo: nuud on vaja külge panna ka data (byte massiiv).
        // todo: meil tuleb see sisse kui String
        // todo: seega enne külge panemist on meil vaja konverteerida String -> Byte arrayks
        byte[] bytes = bytesConverter.stringToBytesArray(cvDto.getCvData());

        // todo: siis saame selle CV objektile külge panna
        // todo: seejärel saame CV objekti adnmebaasi maha salvestada
        cv.setData(bytes);
        cvRepository.save(cv);
    }
    public void deleteCv(Integer userId) {
        User userById = userRepository.findUserById(userId);
        cvRepository.deleteCv(userById);
    }
}