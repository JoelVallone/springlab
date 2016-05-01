package org.digitalpanda.springlab.data;

import java.util.HashMap;

import org.digitalpanda.springlab.spittr.Spitter;
import org.springframework.stereotype.Repository;

@Repository
public class SpitterRepository implements ISpitterRepository{

    HashMap<String,Spitter> spitters;
    private Long nextSpitterId;
    
    public SpitterRepository(){
        spitters = new HashMap<String,Spitter>();
        nextSpitterId = 0L;
        this.save(new Spitter("joel","joel","Joel","Vallone"));
        this.save(new Spitter("angela","angela","Angela","Vallone"));
    }
    
    @Override
    public synchronized long save(Spitter newSpitter) {
        Spitter savedSpitter = 
                new Spitter(nextSpitterId,newSpitter);
        spitters.put(savedSpitter.getUsername(),savedSpitter);
        return savedSpitter.getId();
    }

    @Override
    public Spitter findByUsername(String username) {
        return spitters.get(username);
    }

}
