package com.james.Service;

import com.james.Entity.File;
import com.james.Repository.FileRepository;
import com.james.Utility.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileFileServiceImpl implements FileService {

    @Autowired
    FileRepository fileRepository;;


    @Override
    public File findById(int id) {
        return fileRepository.findById(id);
    }

    @Override
    public List<File> findAll() {
        return fileRepository.findAll();
    }

    @Override
    public File uploadFile(MultipartFile file) throws IOException {

       File f = FileUtility.getMetaDataOfFile(file);
       fileRepository.save(f);
       FileUtility.uploadFile(file,f);
       return  f;


    }
}
