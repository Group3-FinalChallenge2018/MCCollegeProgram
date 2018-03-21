package com.frontendforresume_fc.demo.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.awt.datatransfer.FlavorEvent;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String password;

    private String username;

    private String firstName;

    private String lastName;

//    private String englishStatus;
//    private String employmentStatus;
//    private String underemploymentStatus;
//    private String itcareerInterest;
//    private String diplomaStatus;
//    private String usworkAuth;
//    private String objectoritentedExperience;
//    private String major;
////    Needs Local Date Time Format
//    private String gradYear;
//    private String salary;

    private String email;

    public User(String password, String username, String firstName, String lastName, String email) {
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    //    public User(String password, String username, String firstName, String lastName, String email) {
//        this.password = password;
//        this.username = username;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//    }


//    public User(String password, String username, String firstName, String lastName, String englishStatus, String employmentStatus, String underemploymentStatus, String itcareerInterest, String diplomaStatus, String usworkAuth, String objectoritentedExperience, String major, String gradYear, String salary, String email) {
//        this.password = password;
//        this.username = username;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.englishStatus = englishStatus;
//        this.employmentStatus = employmentStatus;
//        this.underemploymentStatus = underemploymentStatus;
//        this.itcareerInterest = itcareerInterest;
//        this.diplomaStatus = diplomaStatus;
//        this.usworkAuth = usworkAuth;
//        this.objectoritentedExperience = objectoritentedExperience;
//        this.major = major;
//        this.gradYear = gradYear;
//        this.salary = salary;
//        this.email = email;
//    }



    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Requirement> studentRequirements;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Programme> appliedProgramme;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Programme> approvedProgramme;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Programme> acceptedProgramme;

    public User() {
    }

//    public String getEnglishStatus() {
//        return englishStatus;
//    }
//
//    public void setEnglishStatus(String englishStatus) {
//        this.englishStatus = englishStatus;
//    }
//
//    public String getEmploymentStatus() {
//        return employmentStatus;
//    }
//
//    public void setEmploymentStatus(String employmentStatus) {
//        this.employmentStatus = employmentStatus;
//    }
//
//    public String getUnderemploymentStatus() {
//        return underemploymentStatus;
//    }
//
//    public void setUnderemploymentStatus(String underemploymentStatus) {
//        this.underemploymentStatus = underemploymentStatus;
//    }
//
//    public String getItcareerInterest() {
//        return itcareerInterest;
//    }
//
//    public void setItcareerInterest(String itcareerInterest) {
//        this.itcareerInterest = itcareerInterest;
//    }
//
//    public String getDiplomaStatus() {
//        return diplomaStatus;
//    }
//
//    public void setDiplomaStatus(String diplomaStatus) {
//        this.diplomaStatus = diplomaStatus;
//    }
//
//    public String getUsworkAuth() {
//        return usworkAuth;
//    }
//
//    public void setUsworkAuth(String usworkAuth) {
//        this.usworkAuth = usworkAuth;
//    }
//
//    public String getObjectoritentedExperience() {
//        return objectoritentedExperience;
//    }
//
//    public void setObjectoritentedExperience(String objectoritentedExperience) {
//        this.objectoritentedExperience = objectoritentedExperience;
//    }
//
//    public String getMajor() {
//        return major;
//    }
//
//    public void setMajor(String major) {
//        this.major = major;
//    }
//
//    public String getGradYear() {
//        return gradYear;
//    }
//
//    public void setGradYear(String gradYear) {
//        this.gradYear = gradYear;
//    }
//
//    public String getSalary() {
//        return salary;
//    }
//
//    public void setSalary(String salary) {
//        this.salary = salary;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Requirement> getStudentRequirements() {
        return studentRequirements;
    }

    public void setStudentRequirements(Set<Requirement> studentRequirements) {
        this.studentRequirements = studentRequirements;
    }

    public Set<Programme> getAppliedProgramme() {
        return appliedProgramme;
    }

    public void setAppliedProgramme(Set<Programme> appliedProgramme) {
        this.appliedProgramme = appliedProgramme;
    }

    public Set<Programme> getAcceptedProgramme() {
        return acceptedProgramme;
    }

    public Set<Programme> getApprovedProgramme() {
        return approvedProgramme;
    }

    public void setApprovedProgramme(Set<Programme> approvedProgramme) {
        this.approvedProgramme = approvedProgramme;
    }

    public void setAcceptedProgramme(Set<Programme> acceptedProgramme) {
        this.acceptedProgramme = acceptedProgramme;
    }

    public void addProgramme(Programme programme){
        this.appliedProgramme.add(programme);
}

    public boolean containsProgram(Programme programme) {
        return this.appliedProgramme.contains(programme) || this.acceptedProgramme.contains(programme);
    }

    public void addRequirement(Requirement requirement){
        this.studentRequirements.add(requirement);
    }
}