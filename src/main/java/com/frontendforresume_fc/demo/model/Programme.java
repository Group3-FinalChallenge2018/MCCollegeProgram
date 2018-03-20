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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Requirement> programmeRequirements;

    @ManyToMany(mappedBy = "appliedProgramme")
    private Set<User> appliedUsers;

    @ManyToMany(mappedBy = "approvedProgramme")
    private Set<User> approvedUsers;

    @ManyToMany(mappedBy = "acceptedProgramme")
    private Set<User> acceptedUsers;

    public Programme() {
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
}
