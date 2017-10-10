package com.james.Controller;

import com.james.Exception.InvalidIdException;
import com.james.Service.FileFileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.james.Entity.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileFileServiceImpl fileServiceImpl;

    @GetMapping(value = "/{id}")
    public File findById(@PathVariable("id") final int id) throws InvalidIdException {
        if(fileServiceImpl.findById(id) == null) throw  new InvalidIdException("Invalid Input Id");
        return fileServiceImpl.findById(id);

    }

    @GetMapping
    public List<File> findAll(){

        return fileServiceImpl.findAll();
    }


    @PostMapping
    public File uploadFile(@RequestParam("file") MultipartFile file) throws IOException{

        return fileServiceImpl.uploadFile(file);
    }

}
