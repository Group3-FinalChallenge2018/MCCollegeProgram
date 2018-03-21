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

    private String email;

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

    public User(String password, String username, String firstName, String lastName, String email) {
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Programme> appliedProgramme;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Programme> approvedProgramme;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Programme> acceptedProgramme;

    public User() {
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

    public void addAppliedProgramme(Programme programme) {
        this.appliedProgramme.add(programme);
    }

    public void deleteAppliedProgramme(Programme programme) {
        this.appliedProgramme.remove(programme);
    }

    public void addApprovedProgramme(Programme programme){
        this.approvedProgramme.add(programme);
    }

    public void deleteApprovedProgramme(Programme programme){
        this.approvedProgramme.remove(programme);
    }

    public void addAcceptedProgramme(Programme programme){
        this.acceptedProgramme.add(programme);
    }

    public void deleteAcceptedProgramme(Programme programme){
        this.acceptedProgramme.remove(programme);
    }

    public boolean containsAppliedProgramme(Programme programme){
        return this.appliedProgramme.contains(programme);
    }
    public boolean containsProgram(Programme programme) {
        return this.appliedProgramme.contains(programme) || this.acceptedProgramme.contains(programme) || this.approvedProgramme.contains(programme);
    }
}