package com.example.javaweb.services;

import com.example.javaweb.models.Object;
import com.example.javaweb.models.Status;
import com.example.javaweb.repositories.CategoryRepository;
import com.example.javaweb.repositories.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ObjectService {

    @Autowired
    private ObjectRepository objectRepository;
    @Autowired
    private StatusService statusService;


    public List<Object> findAll(){
        return objectRepository.findAll();
    }

    public void saveObjectToDB(MultipartFile file, String name, String location, String description, Date date, Integer categoryid, Integer clientid, Integer statusid){

        Object o = new Object();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a valid file");
        }
        try {
            o.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        o.setName(name);
        o.setLocation(location);
        o.setDescription(description);
        o.setDate(date);
        o.setCategoryid(categoryid);
        o.setClientid(clientid);
        o.setStatusid(statusid);

        objectRepository.save(o);

    }

    public List<Object> getObjectsByStatusId(Integer id){
        return objectRepository.findAllByStatusid(id);
    }

}
