package kks.lend36back.service;

import jakarta.validation.constraints.NotNull;
import kks.lend36back.controller.student.dto.NewCv;
import kks.lend36back.persistence.cv.Cv;
import kks.lend36back.persistence.cv.CvMapper;
import kks.lend36back.persistence.cv.CvRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageService {

    private final CvRepository cvRepository;
    private final CvMapper cvMapper;

    public void addCv (NewCv newCv){
        Cv cv = cvMapper.toCV(newCv);
        //@NotNull byte[] bytes = newCv.getData();
        //Cv cv = cvMapper.toEntity(bytes);
        //User user = new User();
        //user.setId(cv.getId());
        cvRepository.save(cv);

    }

}
