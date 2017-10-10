package com.james.Utility;

import com.james.Entity.File;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileUtility {

    private static final String UPLOAD_DIR = "files/";

    public static File getMetaDataOfFile(MultipartFile file){

        File f = new File();
        f.setName(file.getOriginalFilename());
        f.setFileType(file.getContentType());
        f.setSize((int) file.getSize());
        f.setUrl(UPLOAD_DIR + f.getName());

        return f;

    }

    public static File uploadFile(MultipartFile file , File f) throws IOException {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(f.getUrl());
        Files.write(path, bytes);
        return f ;
    }
}
