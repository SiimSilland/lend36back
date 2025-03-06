package kks.lend36back.persistence.cv;

import kks.lend36back.controller.student.dto.NewCv;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CvMapper {


    @Mapping(source = "data", target = "data")
    @Mapping(numberFormat = "", target = "user")
    Cv toEntity(NewCv newCv);

    }



