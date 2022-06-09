package com.example.javaweb.services;

import com.example.javaweb.models.Status;
import com.example.javaweb.repositories.StatusRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    public Optional<Status> findById(Integer id){
         return statusRepository.findById(id);
    }
}
