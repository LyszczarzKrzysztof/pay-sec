package com.example.paysec.controller;

import com.cloudinary.api.signing.NotificationRequestSignatureVerifier;
import com.example.paysec.entity.Picture;
import com.example.paysec.entity.User;
import com.example.paysec.model.NotificationPojo;
import com.example.paysec.repository.PictureRepo;
import com.example.paysec.repository.UserRepo;
import com.example.paysec.service.Apisec;
import com.example.paysec.service.MapperJson;
import com.example.paysec.service.UserDetailsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@org.springframework.web.bind.annotation.RestController
public class RestControllerWebhook {

    Logger logger = Logger.getLogger(String.valueOf(RestControllerWebhook.class));

    private UserDetailsServiceImpl userDetailsServiceImpl;
    private UserRepo userRepo;
    private PictureRepo pictureRepo;
    private Apisec apisec;
    private MapperJson mapperJson;


    public RestControllerWebhook() {
    }


    @Autowired
    public RestControllerWebhook(UserDetailsServiceImpl userDetailsServiceImpl, UserRepo userRepo, PictureRepo pictureRepo, Apisec apisec, MapperJson mapperJson) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.userRepo = userRepo;
        this.pictureRepo = pictureRepo;
        this.apisec = apisec;
        this.mapperJson = mapperJson;
    }


    @PostMapping(value = "/notification_url/{userId}")
    public void getResponseFromCl(
            @RequestHeader("X-Cld-Timestamp") String timestamp,
            @RequestHeader("X-Cld-Signature") String signature,
            @RequestBody NotificationPojo notificationPojo, @PathVariable Long userId) throws JsonProcessingException {


        String jsonString = mapperJson.mapPojoToString(notificationPojo);


        NotificationRequestSignatureVerifier notificationRequestSignatureVerifier = new
                NotificationRequestSignatureVerifier(apisec.returnApis());



        if(notificationRequestSignatureVerifier.verifySignature(jsonString, timestamp, signature)==true) {

            Optional<User> userById = userDetailsServiceImpl.findUserById(userId);
            User user = userById.get();

            Picture picture = new Picture();

            picture.setUser(user);
            picture.setDescription(notificationPojo.getOriginalFilename());
            picture.setUrlToCloudinary(notificationPojo.getSecureUrl());

            user.addPicture(picture);

            pictureRepo.save(picture);

            userRepo.save(user);
        }else {
            logger.info("Warning: notification not verified!");
        }

    }


}

