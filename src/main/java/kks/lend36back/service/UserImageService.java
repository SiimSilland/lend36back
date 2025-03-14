package kks.lend36back.service;

import kks.lend36back.controller.user_image.dto.UserImageDto;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.persistence.user_image.UserImage;
import kks.lend36back.persistence.user_image.UserImageRepository;
import kks.lend36back.util.BytesConverter;
import kks.lend36back.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserImageService {

    private final UserRepository userRepository;
    private final BytesConverter bytesConverter;
    private final UserImageRepository userImageRepository;

    public void addUserImage(Integer userId, UserImageDto userImageDto) {

        Optional<UserImage> optionalUserImage = userImageRepository.findUserImageBy(userId);

        if (optionalUserImage.isPresent()) {
            UserImage userImage = optionalUserImage.get();
            userImage.setData(BytesConverter.stringToBytesArray(userImageDto.getUserImageData()));
            userImageRepository.save(userImage);
        } else {
            User userById = userRepository.findUserById(userId);
            UserImage userImage = new UserImage();
            userImage.setUser(userById);
            byte[] bytes = BytesConverter.stringToBytesArray(userImageDto.getUserImageData());
            userImage.setData(bytes);
            userImageRepository.save(userImage);
        }
    }

    public void deleteUserImage(Integer userId) {
        User userById = userRepository.findUserById(userId);
        userImageRepository.deleteUserImage(userById);
    }

    public UserImageDto getUserImage(Integer userId) {
        UserImage userImage = userImageRepository.findUserImageBy(userId)
                .orElseThrow(() -> ValidationService.throwForeignKeyNotFoundException("userId", userId));
        byte[] bytes = userImage.getData();
        String userImageData = BytesConverter.bytesArrayToString(bytes);
        UserImageDto userImageDto = new UserImageDto();
        userImageDto.setUserImageData(userImageData);
        userImageDto.setUserId(userId);
        return userImageDto;

    }


}