package com.frontendforresume_fc.demo.service;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.repository.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProgrammeService {
    @Autowired
    ProgrammeRepository programmeRepository;

    @Autowired
    public ProgrammeService(ProgrammeRepository programmeRepository) {
        this.programmeRepository = programmeRepository;
    }

    public Programme findByName(String name){
        return programmeRepository.findByName(name);
    }

    public Iterable<Programme> getAllProgramme(){
        return programmeRepository.findAll();
    }



}
