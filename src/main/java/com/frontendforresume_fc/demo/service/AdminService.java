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
public class AdminService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProgrammeRepository programmeRepository;

    @Autowired
    UserService userService;

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

/*    public HashSet<Requirement> compareUserAndProgrammeRequirements(User user, Programme programme){
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
    }*/
    /*
     * Get a list of students who have applied for a given programme
     */
    public HashSet<User> getAppliedStudents(Programme programme){
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
        user.deleteAppliedProgramme(programme);
        user.addApprovedProgramme(programme);
        userRepository.save(user);
    }

    /*
     * Return a list of students who accepts admission to given programme
     */
    public Set<User> getAcceptedStudents(Programme programme){
        return userRepository.findUsersByAcceptedProgrammeContains(programme);
    }

    /*
     * Return a number of applications (number of applied students) for a given program
     */
    public int getNumOfAppliedStudents(Programme programme){
        return userRepository.countUsersByAppliedProgrammeContains(programme);
    }

    /*
     * Return a number of accepted students for a given program
     */
    public int getNumOfAcceptedStudents(Programme programme){
        return userRepository.countUsersByAcceptedProgrammeContains(programme);
    }

    /*
     * Add other administrators
     */
    public void addNewAdmin(String password, String username, String firstName, String lastName, String email){
        User admin = new User(password, username, firstName, lastName, email);
        userService.saveNewAdmin(admin);
    }
}
