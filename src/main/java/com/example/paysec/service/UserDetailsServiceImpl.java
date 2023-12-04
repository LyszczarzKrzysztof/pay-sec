package com.example.paysec.service;

import com.example.paysec.entity.Picture;
import com.example.paysec.entity.User;
import com.example.paysec.repository.PictureRepo;
import com.example.paysec.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    private UserRepo userRepo;
    private PictureRepo pictureRepo;

    @Autowired
    public UserDetailsServiceImpl(UserRepo userRepo, PictureRepo pictureRepo) {
        this.userRepo = userRepo;
        this.pictureRepo = pictureRepo;
    }



    public void signInNewUser(User user){
        userRepo.save(user);
//        for (Picture p:
//             user.getPictures()) {
//            pictureRepo.save(p);
//        }
        logger.info("User: "+user.getUsername()+" created!");
    }

    public Optional<User> findUserByName(String username){
        return userRepo.findByUsername(username);
    }

    public Optional<User> findUserById(Long id){return userRepo.findUserById(id);};


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            //todo throw if not exist
            return userRepo.findByUsername(s).get();
    }
}
