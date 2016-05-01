package org.digitalpanda.springlab.spittr;

import java.util.Random;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

public class Spitter {
    
    @NotNull
    @Size(min=5, max=16, message="{username.size}")
    private String username;
    
    @NotNull
    @Size(min=5, max=25, message="{password.size}")
    private String password;
    
    @NotNull
    @Size(min=2, max=30, message="{firstName.size}")
    private String firstName;
    
    @NotNull
    @Size(min=2, max=30, message="{lastName.size}")
    private String lastName;
    
    @NotNull
    @Email(message="{email.valid}")
    private String email;

    private MultipartFile profilePicture;

    private long id;

    
    public Spitter(){}
    
    public Spitter( 
            String username,    String password,
            String firstName,   String lastName){
        this.id = System.currentTimeMillis() + 
                (new Random()).nextInt(Integer.MAX_VALUE);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;        
    }
    
    public Spitter(long id, 
            String username,    String password,
            String firstName,   String lastName){
        this(username,password,firstName,lastName);
        this.id = id;        
    }
    

    public Spitter(long id, Spitter spitter){
        this(   id,
                spitter.username,spitter.password,                
                spitter.firstName,spitter.lastName);
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getId() {
        return id;
    }

    public void setId(long timeStamp) {
        this.id = timeStamp;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
    
    public MultipartFile getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(MultipartFile profilePicture) {
        this.profilePicture = profilePicture;
    }
    
    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(
                this, that, "id", "firstName", "lastName", "username");
    }
    
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(
                this, "id", "firstName", "lastName", "username");
    }
}
