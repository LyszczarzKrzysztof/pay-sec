package com.example.paysec.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface FileUploadInterface {
    void uploadToLocalFolder(MultipartFile multipartFile, Path path);
    void deleteOldFiles(Path path) throws IOException;
    void createDirectory(String dir) throws IOException;
}
