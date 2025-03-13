package kks.lend36back.persistence.user_image;

import kks.lend36back.controller.user_image.dto.UserImageDto;
import kks.lend36back.util.BytesConverter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserImageMapper {

    @Mapping(source = "userImageData", target = "data", qualifiedByName = "toData")
    UserImage toUserImage(UserImageDto userImageDto);

    @Named("toData")
    static byte[] toData(String imageData){
        byte[] bytes = BytesConverter.stringToBytesArray(imageData);
        return bytes;
    }

}