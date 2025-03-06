package kks.lend36back.persistence.cv;

import kks.lend36back.controller.student.dto.NewCv;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.util.BytesConverter;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CvMapper {

    @Autowired
    private UserRepository userRepository;


    @Mapping(source = "user", target = "user", qualifiedByName = "mapUser")
    public abstract Cv toEntity(NewCv newCv);

    @Named("mapUser")
    public User mapUser(Integer user);
        return userRepository.findById()

    }

