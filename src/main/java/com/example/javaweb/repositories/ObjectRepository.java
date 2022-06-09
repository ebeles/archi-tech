package com.example.javaweb.repositories;

import com.example.javaweb.models.Object;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ObjectRepository extends JpaRepository<Object, Integer> {


    List<Object> findAllByStatusid(Integer id);


}
