package com.frontendforresume_fc.demo.service;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.Role;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.repository.ProgrammeRepository;
import com.frontendforresume_fc.demo.repository.UserRepository;
import com.google.common.collect.Lists;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;
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

    @Autowired
    EmailService emailService;
    /*
     * Check if given User is admin or not
     */
    public boolean isAdmin(User user) {
        for (Role role : user.getRoles()) {
            if (role.getRole().equalsIgnoreCase("ADMIN")) {
                return true;
            }
        }
        return false;
    }

    public User compareUserAndProgrammeRequirements(User user, Programme programme) {
        User tempUser = new User();

        tempUser.setEnglishStatus(user.getEnglishStatus().equalsIgnoreCase(programme.getEnglishStatus()) ? "YES" : "NO");
        tempUser.setEmploymentStatus(user.getEmploymentStatus().equalsIgnoreCase(programme.getEmploymentStatus()) ? "YES" : "NO");
        tempUser.setUnderemploymentStatus(user.getUnderemploymentStatus().equalsIgnoreCase(programme.getUnderemploymentStatus()) ? "YES" : "NO");
        tempUser.setDiplomaStatus(user.getDiplomaStatus().equalsIgnoreCase(programme.getDiplomaStatus()) ? "YES" : "NO");
        tempUser.setItcareerInterest(user.getItcareerInterest().equalsIgnoreCase(programme.getItcareerInterest()) ? "YES" : "NO");
        tempUser.setMajor(user.getMajor().equalsIgnoreCase(programme.getMajor()) ? "YES" : "NO");
        tempUser.setSalary(user.getSalary().equalsIgnoreCase(programme.getSalary()) ? "YES" : "NO");
        tempUser.setUsworkAuth(user.getUsworkAuth().equalsIgnoreCase(programme.getUsworkAuth()) ?"YES":"NO");
        tempUser.setObjectoritentedExperience(user.getObjectoritentedExperience().equalsIgnoreCase(programme.getObjectoritentedExperience())?"YES":"NO");
        tempUser.setGradYear(user.getGradYear().equalsIgnoreCase(programme.getGradYear()) ? "YES" :  "NO");
        tempUser.setComfortableComputer(user.getComfortableComputer().equalsIgnoreCase(programme.getComfortableComputer()) ? "YES" : "NO");
        tempUser.setUnderstandOOP(user.getUnderstandOOP().equalsIgnoreCase(programme.getUnderstandOOP()) ? "YES" : "NO");
        tempUser.setAble2WorkUS(user.getAble2WorkUS().equalsIgnoreCase(programme.getAble2WorkUS()) ? "YES" : "NO");

        return tempUser;
    }

    /*
     * Get a list of students who have applied for a given programme
     */
    public HashSet<User> getAppliedStudents(Programme programme) {
        return userRepository.findUsersByAppliedProgrammeContains(programme);
    }

    /*
     * Check if a given User and Programme meet the criteria or not
     */
    public boolean meetCriteria(User user, Programme programme) {
        if(programme.getName().equalsIgnoreCase("Hiring in Tech")) {
            return user.getEnglishStatus().equalsIgnoreCase(programme.getEnglishStatus()) &&
                    user.getEmploymentStatus().equalsIgnoreCase(programme.getEmploymentStatus()) &&
                    user.getUnderemploymentStatus().equalsIgnoreCase(programme.getUnderemploymentStatus()) &&
                    user.getComfortableComputer().equalsIgnoreCase(programme.getComfortableComputer()) &&
                    user.getItcareerInterest().equalsIgnoreCase(programme.getItcareerInterest()) &&
                    user.getDiplomaStatus().equalsIgnoreCase(programme.getDiplomaStatus()) &&
                    user.getUsworkAuth().equalsIgnoreCase(programme.getUsworkAuth());
        }

        return  user.getUnderstandOOP().equalsIgnoreCase(programme.getUnderstandOOP()) &&
        user.getObjectoritentedExperience().equalsIgnoreCase(programme.getObjectoritentedExperience()) &&
        user.getMajor().equalsIgnoreCase(programme.getMajor()) &&
        user.getGradYear().equalsIgnoreCase(programme.getGradYear()) &&
        user.getSalary().equalsIgnoreCase(programme.getSalary()) &&
        user.getAble2WorkUS().equalsIgnoreCase(programme.getAble2WorkUS());

    }

    /*
     * Approve a given Student to admit to the programme
     */
    public void approveStudent2Programme(User user, Programme programme) {
        user.deleteAppliedProgramme(programme);
        user.addApprovedProgramme(programme);
        userRepository.save(user);
        programmeRepository.save(programme);
    }

    /*
     * Return a list of students who accepts admission to given programme
     */
    public Set<User> getAcceptedStudents(Programme programme) {
        return userRepository.findUsersByAcceptedProgrammeContains(programme);
    }

    /*
     * Return a number of applications (number of applied students) for a given program
     */
    public int getNumOfAppliedStudents(Programme programme) {
        return userRepository.countUsersByAppliedProgrammeContains(programme);
    }

    /*
     * Return a number of accepted students for a given program
     */
    public int getNumOfAcceptedStudents(Programme programme) {
        return userRepository.countUsersByAcceptedProgrammeContains(programme);
    }

    /*
     * Add other administrators
     */
    public void addNewAdmin(String password, String username, String firstName, String lastName, String email) {
        User admin = new User(password, username, firstName, lastName, email);
        userService.saveNewAdmin(admin);
    }

    public void sendEmailWithoutTemplating(User user, Programme programme) {
        final Email email;

        StringBuilder emailBody = new StringBuilder();
        emailBody.append("Dear " + user.getFirstName() + "\n");
        emailBody.append("We want to congrats you for your admission to " + programme.getName() + "\n");
        emailBody.append("We hope to see you soon!\n");
        emailBody.append("Sincerely");

        try {
            email = DefaultEmail.builder()
                    .from(new InternetAddress("cicero@mala-tempora.currunt", "Marco Tullio Cicerone "))
                    .to(Lists.newArrayList(new InternetAddress(user.getEmail(), user.getFirstName() + " " + user.getLastName())))
                    .subject("Congratulation to Your Admission to " + programme.getName())
                    .body(emailBody.toString())
                    .encoding("UTF-8").build();

            emailService.send(email);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}