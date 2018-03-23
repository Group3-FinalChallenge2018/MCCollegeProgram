package com.frontendforresume_fc.demo.service;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.Role;
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
    UserService userService;

    @Autowired
    ProgrammeService programmeService;

    /*
     * Check if given User is student or not
     */
    public boolean isStudent(User user){
        for(Role role: user.getRoles()){
            if(role.getRole().equalsIgnoreCase("USER")){
                return true;
            }
        }
        return false;
    }

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
        //if user is not student return
        if(!isStudent(user)){
            System.out.println("User is not student");
            return;
        }

        //if student already applied or got accepted, student cannot apply
        if(user.containsProgram(programme)){
            System.out.println("This student already applies or accepted this program");
            return;
        }
        user.addAppliedProgramme(programme);
        userService.saveUser(user);
        programmeService.saveProgramme(programme);
    }

    /*
     * Get a list of programmes that students have been approved for
     */
    public Set<Programme> getApprovedProgramme(User user){
        return user.getApprovedProgramme();
    }

    /*
     * Student accepts admission into a programme
     */
    public void acceptProgramme(User user, Programme programme){
        user.deleteApprovedProgramme(programme);
        user.addAcceptedProgramme(programme);
        userService.saveUser(user);
        programmeService.saveProgramme(programme);
    }
}