package com.frontendforresume_fc.demo.service;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.repository.ProgrammeRepository;
import com.frontendforresume_fc.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProgrammeRepository programmeRepository;

    /*
     * See suggestions of programmes that they should apply for
     */
    public Set<Programme> getProgrammeSuggestion(User user){
        return new HashSet<>();
    }

    /*
     * Student applies to programme
     */
    public void apply2Programme(User user, Programme programme){
        //if student already applied or got accepted, student cannot apply
        if(user.containsProgram(programme)){
            return;
        }
        user.addProgramme(programme);
        userRepository.save(user);

        if(programme.getAppliedUsers() == null){
            programme.setAppliedUsers(new HashSet<>());
        }
        programme.addAppliedUsers(user);
        programmeRepository.save(programme);
    }

    /*
     * Get a list of programmes that students have been approved for
     */
    public Set<Programme> getApprovedProgramme(User user){
        return new HashSet<>();
    }

    /*
     * Student accepts admission into a programme
     */
    public void acceptProgramme(User user, Programme programme){

    }

    /*
     * Student declines admission into a programme
     */
    public void declineProgramme(User user, Programme programme){

    }
}
