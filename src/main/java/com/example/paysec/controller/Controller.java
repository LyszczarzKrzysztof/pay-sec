package com.example.paysec.controller;

import com.example.paysec.entity.User;
import com.example.paysec.interfaces.FileUploadInterface;
import com.example.paysec.security.AuthenticationFacadeImpl;
import com.example.paysec.service.UploaderService;
import com.example.paysec.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;


@Validated
@org.springframework.stereotype.Controller
public class Controller {

    private UploaderService uploaderService;
    private UserDetailsServiceImpl userDetailsServiceImpl;
    private PasswordEncoder passwordEncoder;

    private AuthenticationFacadeImpl authenticationFacadeImpl;

    private FileUploadInterface fileUploadInterface;

    public Controller() {
    }

    @Autowired
    public Controller(UploaderService uploaderService,
                      UserDetailsServiceImpl userDetailsServiceImpl,
                      PasswordEncoder passwordEncoder,
                      AuthenticationFacadeImpl authenticationFacadeImpl,
                      FileUploadInterface fileUploadInterface) {
        this.uploaderService = uploaderService;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.passwordEncoder = passwordEncoder;
        this.authenticationFacadeImpl = authenticationFacadeImpl;
        this.fileUploadInterface = fileUploadInterface;
    }

    @GetMapping("/robo")
    public String robo(Model model, @Value("${CONSTANT}") String constant) {
        model.addAttribute("constant", constant);
        model.addAttribute("link", ServletUriComponentsBuilder
                .fromCurrentContextPath().build().toUriString()
                +"/choose-upload");
        return "robo";
    }

    @GetMapping("/choose-upload")
    public String findFile(Model model, @Value("${CONSTANT}") String constant){
        model.addAttribute("constant", constant);
        return "/choose-upload";
    }


    @PostMapping(value= "/choose-upload")
    public String uploadFile(@RequestParam("file")MultipartFile multipartFile,
                             @Value("${TEMPPATH}") String tempPath) throws IOException {

        Authentication authentication = authenticationFacadeImpl.getAuthentication();

        Optional<User> user = userDetailsServiceImpl.findUserByName(authentication.getName());

        String dir= tempPath+user.get().getId()+"/";
        fileUploadInterface.createDirectory(dir);
        fileUploadInterface.deleteOldFiles(Paths.get(tempPath));
        Path localUploadPath = Paths.get(dir+multipartFile.getOriginalFilename());
        fileUploadInterface.uploadToLocalFolder(multipartFile, localUploadPath);
        String absolutePath = localUploadPath.toString();
        uploaderService.uploadImage(absolutePath,
                        Objects.requireNonNull(multipartFile.getOriginalFilename())
                        .substring(0, multipartFile.getOriginalFilename().lastIndexOf(46)),
                user.get().getId().toString()
        );
        return "redirect:/robo";
    }


    @GetMapping(value = "/form-sign-up")
    public String inputNewUser(Model model){

        User user = new User();

        model.addAttribute("user",user);
        model.addAttribute("form", user);

        return "/form-sign-up";
    }

    @PostMapping(value = "/form-sign-up")
    public String signInUser(@Valid @ModelAttribute User user){
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsServiceImpl.signInNewUser(user);
        return "redirect:/choose-upload";
    }

    @GetMapping(value = "/start")
    public String viewAtStart(){
        return "start";
    }


}
