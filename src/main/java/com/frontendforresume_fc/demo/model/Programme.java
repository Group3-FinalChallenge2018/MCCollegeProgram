package com.frontendforresume_fc.demo.model;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String englishStatus;
    private String employmentStatus;
    private String underemploymentStatus;
    private String itcareerInterest;
    private String diplomaStatus;
    private String usworkAuth;
    private String objectoritentedExperience;
    private String major;
    //    Needs Local Date Time Format
    private String gradYear;
    private String salary;

    public Programme(String name, String englishStatus, String employmentStatus, String underemploymentStatus, String itcareerInterest, String diplomaStatus, String usworkAuth, String objectoritentedExperience, String major, String gradYear, String salary, Set<Requirement> programmeRequirements) {
        this.name = name;
        this.englishStatus = englishStatus;
        this.employmentStatus = employmentStatus;
        this.underemploymentStatus = underemploymentStatus;
        this.itcareerInterest = itcareerInterest;
        this.diplomaStatus = diplomaStatus;
        this.usworkAuth = usworkAuth;
        this.objectoritentedExperience = objectoritentedExperience;
        this.major = major;
        this.gradYear = gradYear;
        this.salary = salary;
        this.programmeRequirements = programmeRequirements;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Requirement> programmeRequirements;

    @ManyToMany(mappedBy = "appliedProgramme", cascade = CascadeType.ALL)
    private Set<User> appliedUsers;

    @ManyToMany(mappedBy = "approvedProgramme", cascade = CascadeType.ALL)
    private Set<User> approvedUsers;

    @ManyToMany(mappedBy = "acceptedProgramme", cascade = CascadeType.ALL)
    private Set<User> acceptedUsers;

    public Programme() {
    }

    public String getEnglishStatus() {
        return englishStatus;
    }

    public void setEnglishStatus(String englishStatus) {
        this.englishStatus = englishStatus;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getUnderemploymentStatus() {
        return underemploymentStatus;
    }

    public void setUnderemploymentStatus(String underemploymentStatus) {
        this.underemploymentStatus = underemploymentStatus;
    }

    public String getItcareerInterest() {
        return itcareerInterest;
    }

    public void setItcareerInterest(String itcareerInterest) {
        this.itcareerInterest = itcareerInterest;
    }

    public String getDiplomaStatus() {
        return diplomaStatus;
    }

    public void setDiplomaStatus(String diplomaStatus) {
        this.diplomaStatus = diplomaStatus;
    }

    public String getUsworkAuth() {
        return usworkAuth;
    }

    public void setUsworkAuth(String usworkAuth) {
        this.usworkAuth = usworkAuth;
    }

    public String getObjectoritentedExperience() {
        return objectoritentedExperience;
    }

    public void setObjectoritentedExperience(String objectoritentedExperience) {
        this.objectoritentedExperience = objectoritentedExperience;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGradYear() {
        return gradYear;
    }

    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Programme(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Requirement> getProgrammeRequirements() {
        return programmeRequirements;
    }

    public void setProgrammeRequirements(Set<Requirement> programmeRequirements) {
        this.programmeRequirements = programmeRequirements;
    }

    public void addRequirement(Requirement requirement){
        this.programmeRequirements.add(requirement);
    }

    public Set<User> getAppliedUsers() {
        return appliedUsers;
    }

    public void setAppliedUsers(Set<User> appliedUsers) {
        this.appliedUsers = appliedUsers;
    }

    public Set<User> getAcceptedUsers() {
        return acceptedUsers;
    }

    public void setAcceptedUsers(Set<User> acceptedUsers) {
        this.acceptedUsers = acceptedUsers;
    }

    public void addAppliedUsers(User user){
        this.appliedUsers.add(user);
    }

    public Set<User> getApprovedUsers() {
        return approvedUsers;
    }

    public void setApprovedUsers(Set<User> approvedUsers) {
        this.approvedUsers = approvedUsers;
    }

    public void addAppliedUser(User user) {
        this.appliedUsers.add(user);
    }

    public void deleteAppliedUser(Programme programme) {
        this.appliedUsers.remove(programme);
    }

    public void addApprovedUser(User user){
        this.approvedUsers.add(user);
    }

    public void deleteApprovedUser(User user){
        this.approvedUsers.remove(user);
    }

    public void addAcceptedUser(User user){
        this.acceptedUsers.add(user);
    }

    public void deleteAcceptedUser(User user) {
        this.acceptedUsers.remove(user);
    }
}
