package com.james.Service;

import com.james.Entity.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    public File findById(int id);

    public List<File> findAll();

    public File uploadFile(MultipartFile file) throws IOException;

}
