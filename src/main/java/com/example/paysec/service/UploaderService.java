package com.example.paysec.service;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.example.paysec.PaySecApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.management.Notification;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import javax.swing.filechooser.FileView;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Service
public class UploaderService {
    Cloudinary cloudinary = Singleton.getCloudinary();

    public UploaderService() {
    }

    public String chooseFile() {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setDirectory("D:");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        dialog.setAlwaysOnTop(true);
        String file = new File(dialog.getFile()).getAbsolutePath();
        logger.info(file + " chosen.");
        return file;

    }

    public String chooseFile2(){

        final JFrame frame = new JFrame("Open File Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setAlwaysOnTop(true);


        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getAbsolutePath();
            logger.info(path);
            return path;

        }

        chooser.getSelectedFile();

        return "-1";
    }

    public void deleteImage(String public_id) throws IOException {
        cloudinary.uploader().destroy(public_id, ObjectUtils.emptyMap());
    }


    public void uploadImage(String absoluteFilePath, String fileName, String userId) throws IOException {
       cloudinary.uploader().upload(absoluteFilePath,
                ObjectUtils.asMap(
                        "public_id", fileName,
                        "folder", userId,
                        "type", "upload",
                        "notification_url", ServletUriComponentsBuilder
                                            .fromCurrentContextPath()
                                            .build()
                                            .toUriString()+"/notification_url/"+userId,
                        "eager", Arrays.asList(
                                new EagerTransformation().width(400).height(400)
                                        .crop("crop").gravity("face"))
                ));



    }



    private static Logger logger = LogManager.getLogger(PaySecApplication.class);
}
