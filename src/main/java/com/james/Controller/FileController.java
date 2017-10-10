package com.james.Controller;

import com.james.Exception.InvalidInputId;
import com.james.Service.FileService;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
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
    private FileService fileService;

    @GetMapping(value = "/{id}")
    public File findById(@PathVariable("id") final int id) throws InvalidInputId {
        if(fileService.findById(id) == null) throw  new InvalidInputId("Invalid Input Id");
        return fileService.findById(id);

    }

    @GetMapping
    public List<File> findAll(){

        return fileService.findAll();
    }


    @PostMapping
    public File uploadFile(@RequestParam("file") MultipartFile file) throws IOException{

        return fileService.uploadFile(file);
    }

}
