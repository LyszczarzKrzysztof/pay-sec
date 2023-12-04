package com.example.paysec;

import com.example.paysec.entity.User;
import com.example.paysec.repository.PictureRepo;
import com.example.paysec.repository.UserRepo;
import com.example.paysec.service.UserDetailsServiceImpl;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CreateUserAtStart {

    private UserRepo userRepo;
    private PictureRepo pictureRepo;
    private PasswordEncoder passwordEncoder;
    private UserDetailsServiceImpl userDetailsServiceImpl;

    public CreateUserAtStart(UserRepo userRepo, PictureRepo pictureRepo, PasswordEncoder passwordEncoder, UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userRepo = userRepo;
        this.pictureRepo = pictureRepo;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

//    @EventListener(ApplicationReadyEvent.class)
    public void createFirstUser() {
        User user = new User();
        user.setUsername("Krzysiek");
        user.setPassword(passwordEncoder.encode("krzysiek"));
        user.setRole("ROLE_USER");
        user.setEmail("krzysiek@krzysiek.pl");
        user.setPictures(new ArrayList<>());

//        Picture picture = new Picture();
//        Picture picture1 = new Picture();
//        picture.setUser(user);
//        picture1.setUser(user);
//        picture.setDescription("sample");
//        picture1.setDescription("picture1");
//        picture.setUrlToCloudinary("https://res.cloudinary.com/dpnmxdpbp/image/upload/v1597264609/sample.jpg");
//        picture1.setUrlToCloudinary("https://res.cloudinary.com/dpnmxdpbp/image/upload/v1641673542/picture1.jpg");
//
//        user.addPicture(picture));
//        user.addPicture(picture1));

        userDetailsServiceImpl.signInNewUser(user);

        User user1 = new User();
        user1.setUsername("Jozek");
        user1.setPassword(passwordEncoder.encode("jozek"));
        user1.setRole("ROLE_USER");
        user1.setEmail("jozek@jozek.pl");
        user1.setPictures(new ArrayList<>());

//        Picture picture2 = new Picture();
//        Picture picture3 = new Picture();
//        picture2.setUser(user1);
//        picture3.setUser(user1);
//        picture2.setDescription("picture2");
//        picture3.setDescription("picture3");
//        picture2.setUrlToCloudinary("https://res.cloudinary.com/dpnmxdpbp/image/upload/v1642373589/picture2.jpg.jpg");
//        picture3.setUrlToCloudinary("https://res.cloudinary.com/dpnmxdpbp/image/upload/v1642373622/picture3.jpg.jpg");
//
//        user1.setPictures(Arrays.asList(picture2, picture3));

        userDetailsServiceImpl.signInNewUser(user1);

        User user2 = new User();
        user2.setUsername("Franek");
        user2.setPassword(passwordEncoder.encode("franek"));
        user2.setRole("ROLE_USER");
        user2.setEmail("franek@franek.pl");
        user2.setPictures(new ArrayList<>());

//        Picture picture4 = new Picture();
//        Picture picture5 = new Picture();
//        picture4.setUser(user2);
//        picture5.setUser(user2);
//        picture4.setDescription("picture4");
//        picture5.setDescription("picture5");
//        picture4.setUrlToCloudinary("https://res.cloudinary.com/dpnmxdpbp/image/upload/v1642373668/picture4.jpg.jpg");
//        picture5.setUrlToCloudinary("https://res.cloudinary.com/dpnmxdpbp/image/upload/v1642373679/picture5.jpg.jpg");
//
//        user2.setPictures(Arrays.asList(picture4, picture5));

        userDetailsServiceImpl.signInNewUser(user2);

    }
}
