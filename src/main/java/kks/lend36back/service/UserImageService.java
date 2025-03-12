package kks.lend36back.service;

import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.controller.user_image.dto.UserImageDto;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.persistence.user_image.UserImage;
import kks.lend36back.persistence.user_image.UserImageRepository;
import kks.lend36back.util.BytesConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserImageService {

    private final UserRepository userRepository;
    private final BytesConverter bytesConverter;
    private final UserImageRepository userImageRepository;


    public void addUserImage(UserImageDto userImageDto) {
        User userById = userRepository.findUserById(userImageDto.getUserId());
        UserImage userImage = new UserImage();
        userImage.setUser(userById);
        byte[] bytes = bytesConverter.stringToBytesArray(userImageDto.getUserImageData());
        userImage.setData(bytes);
        userImageRepository.save(userImage);
    }

    public void deleteUserImage(Integer userId) {
        User userById = userRepository.findUserById(userId);
        userImageRepository.deleteUserImage(userById);
    }
}