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

    private String englishLearner;
    private String unemployed;
    private String underemployed;
    private String comfortableComputer;
    private String interestIT;
    private String highschool;
    private String legalUS;

    private String oop;
    private String experienceOOP;
    private String majorCS;
    private String graduated6;
    private String earning42000;
    private String workUS;

    @ManyToMany(mappedBy = "appliedProgramme", cascade = CascadeType.ALL)
    private Set<User> appliedUsers;

    @ManyToMany(mappedBy = "approvedProgramme", cascade = CascadeType.ALL)
    private Set<User> approvedUsers;

    @ManyToMany(mappedBy = "acceptedProgramme", cascade = CascadeType.ALL)
    private Set<User> acceptedUsers;

    public Programme() {
    }

    public Programme(String name) {
        this.name = name;
    }

    public String getEnglishLearner() {
        return englishLearner;
    }

    public void setEnglishLearner(String englishLearner) {
        this.englishLearner = englishLearner;
    }

    public String getUnemployed() {
        return unemployed;
    }

    public void setUnemployed(String unemployed) {
        this.unemployed = unemployed;
    }

    public String getUnderemployed() {
        return underemployed;
    }

    public void setUnderemployed(String underemployed) {
        this.underemployed = underemployed;
    }

    public String getComfortableComputer() {
        return comfortableComputer;
    }

    public void setComfortableComputer(String comfortableComputer) {
        this.comfortableComputer = comfortableComputer;
    }

    public String getInterestIT() {
        return interestIT;
    }

    public void setInterestIT(String interestIT) {
        this.interestIT = interestIT;
    }

    public String getHighschool() {
        return highschool;
    }

    public void setHighschool(String highschool) {
        this.highschool = highschool;
    }

    public String getLegalUS() {
        return legalUS;
    }

    public void setLegalUS(String legalUS) {
        this.legalUS = legalUS;
    }

    public String getOop() {
        return oop;
    }

    public void setOop(String oop) {
        this.oop = oop;
    }

    public String getExperienceOOP() {
        return experienceOOP;
    }

    public void setExperienceOOP(String experienceOOP) {
        this.experienceOOP = experienceOOP;
    }

    public String getMajorCS() {
        return majorCS;
    }

    public void setMajorCS(String majorCS) {
        this.majorCS = majorCS;
    }

    public String getGraduated6() {
        return graduated6;
    }

    public void setGraduated6(String graduated6) {
        this.graduated6 = graduated6;
    }

    public String getEarning42000() {
        return earning42000;
    }

    public void setEarning42000(String earning42000) {
        this.earning42000 = earning42000;
    }

    public String getWorkUS() {
        return workUS;
    }

    public void setWorkUS(String workUS) {
        this.workUS = workUS;
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
