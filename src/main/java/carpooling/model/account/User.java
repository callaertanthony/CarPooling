package carpooling.model.account;

import carpooling.model.journey.Journey;
import carpooling.model.journey.Step;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by anthonycallaert on 19/03/15.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = true, updatable = true)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = true, updatable = true)
    private String firstName;

    @Column(nullable = true, updatable = true)
    private String lastName;

    @Basic
    private String picturePath;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private Set<Journey> journeysCreated;

    @ManyToMany(mappedBy = "startPassengers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Step> startSteps = new HashSet<Step>();

    @ManyToMany(mappedBy = "destPassengers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Step> destSteps = new HashSet<Step>();

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", role=" + role +
                ", gender=" + gender +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Set<Journey> getJourneysCreated() {
        return journeysCreated;
    }

    public void setJourneysCreated(Set<Journey> journeysCreated) {
        this.journeysCreated = journeysCreated;
    }

    public Set<Step> getStartSteps() {
        return startSteps;
    }

    public void setStartSteps(Set<Step> startSteps) {
        this.startSteps = startSteps;
    }

    public Set<Step> getDestSteps() {
        return destSteps;
    }

    public void setDestSteps(Set<Step> destSteps) {
        this.destSteps = destSteps;
    }

    public void addStartStep(Step step){
        if(step != null){
            if(this.startSteps == null){
                this.startSteps = new HashSet<Step>();
            }
            this.startSteps.add(step);
        }
    }

    public void addDestStep(Step step){
        if(step != null){
            if(this.destSteps == null){
                this.destSteps = new HashSet<Step>();
            }
            this.destSteps.add(step);
        }
    }

    //TODO remove step
}
