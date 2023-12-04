package com.example.paysec.intefaceImpl;

import com.example.paysec.interfaces.FileUploadInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.logging.Logger;

@Service
public class FileUploadInterfaceImpl implements FileUploadInterface {

    Logger logger = Logger.getLogger(String.valueOf(FileUploadInterfaceImpl.class));

    @Override
    public void uploadToLocalFolder(MultipartFile multipartFile, Path localUploadPath) {
        try {
            byte[] data = multipartFile.getBytes();
            Path writePath = Files.write(localUploadPath, data);
            File file = writePath.toFile();
            Date date = new Date();
            date.setTime(file.lastModified());
            System.out.println(date);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOldFiles(Path path) throws IOException {

            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException {
                    if (!Files.isDirectory(file) && attrs.lastModifiedTime().toMillis()<System.currentTimeMillis()-10*60*1000) {
                        Files.delete(file);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        }

    @Override
    public void createDirectory(String dir) {
        try {
            Files.createDirectory(Paths.get(dir));
        } catch (IOException e) {
            logger.info("Directory: "+dir+" already exists.");
        }
    }

}


