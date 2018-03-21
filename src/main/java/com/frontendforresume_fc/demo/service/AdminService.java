package com.frontendforresume_fc.demo.service;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.Requirement;
import com.frontendforresume_fc.demo.model.Role;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.repository.ProgrammeRepository;
import com.frontendforresume_fc.demo.repository.UserRepository;
import org.codehaus.groovy.util.HashCodeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProgrammeRepository programmeRepository;

    /*
     * Check if given User is admin or not
     */
    public boolean isAdmin(User user){
        for(Role role: user.getRoles()){
            if(role.getRole().equalsIgnoreCase("ADMIN")){
                return true;
            }
        }
        return false;
    }

    public HashSet<Requirement> compareUserAndProgrammeRequirements(User user, Programme programme){
        HashSet<Requirement> userEligibilty = new HashSet<>();
        for(Requirement studentReq: user.getStudentRequirements()){
            for(Requirement programmeReq : programme.getProgrammeRequirements()){
                String programmReqDes = programmeReq.getDescription();
                String studentReqDes = studentReq.getDescription();
                if(programmReqDes.equalsIgnoreCase(studentReqDes)){
                    Requirement req = new Requirement(programmReqDes,
                            programmeReq.isAnswer() && studentReq.isAnswer());
                    userEligibilty.add(req);
                    break;
                }
            }
        }

        return userEligibilty;
    }
    /*
     * Get a list of students who have applied for a given programme
     */
    public HashSet<User> getAppliedStudents(Programme programme){
        /*
        HashSet appliedStudents = new HashSet();
        for(User user : userRepository.findAll()){
            if(user.containsAppliedProgramme(programme)){
                appliedStudents.add(user);
                break;
            }
        }
        return appliedStudents;
        */
        return userRepository.findUsersByAppliedProgrammeContains(programme);
    }

    /*
     * Check if a given User meets the criteria or not
     */
    public boolean meetCriteria(User user){
        return false;
    }

    /*
     * Approve a given Student to admit to the programme
     */
    public void approveStudent2Programme(User user,  Programme programme){

    }

    /*
     * Return a list of students who accepts admission to given programme
     */
    public Set<User> getAcceptedStudents(Programme programme){
        return new HashSet<>();
    }

    /*
     * Add other administrators
     */
    public void addNewAdmin(){

    }
}
