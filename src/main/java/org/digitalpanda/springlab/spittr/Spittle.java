package org.digitalpanda.springlab.spittr;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spittle {
    private Long id;

    @NotNull
    @Size(min=1, max=1024, message="The message size must be between 1 and 1024 characters.")
    private String message;
  
    private Date time;    
    private Double latitude;    
    private Double longitude;
    
    public Spittle(){};
    
    public Spittle(
            String message, Date time, Double longitude, Double latitude) {
        setTime(time);
        this.message = message;
        this.longitude = longitude;
        this.latitude = latitude;
    }
   
    public Spittle(Long id,
            String message, Date time, Double longitude, Double latitude) {
        this(message,time,longitude,latitude);
        this.id = id;
    }
    
    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }
    
    public Spittle(Long id, Spittle originSpittle) {
        setTime(time);
        this.message = originSpittle.message;
        this.longitude = originSpittle.longitude;
        this.latitude = originSpittle.latitude;
        this.time = originSpittle.time;
        this.id = id;
        
    }
    
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
   
    
    public Date getTime() {
        return time;
    }
    
    public void setTime(Date time){
        if (time == null){
            this.time = time;
        }else{
            this.time = time;
        }
    }
    
    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }
    
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}