package org.digitalpanda.springlab.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.digitalpanda.springlab.spittr.DuplicateSpittleException;
import org.digitalpanda.springlab.spittr.Spittle;
import org.springframework.stereotype.Repository;

@Repository
public class SpittleRepository implements ISpittleRepository{

    
    private HashMap<Long, Spittle> spittleStore;
    private Long nextSpittleId;
    
    public SpittleRepository(){
        spittleStore = new HashMap<Long, Spittle>();
        nextSpittleId = 0L;
        this.save(new Spittle(
                "First spittle ever !",
                new Date(System.currentTimeMillis())
             ));
    }
    
    @Override
    public List<Spittle> findSpittles(long start, int count) {
        if (count > 20){count = 20;        }
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i=0; i < count; i++) {
            spittles.add(this.findOne(i));
        }
        return spittles;
    }

    @Override
    public Spittle findOne(long spittleId) {
        if (spittleId < 0 ){
            return null;
        }if(spittleStore.containsKey(spittleId)){
            return spittleStore.get(spittleId);
        }else{
            return new Spittle("Generated spittle " + spittleId, new Date());
        }
    }


    @Override
    public synchronized Long save(Spittle spittleToSave) throws DuplicateSpittleException{

        Spittle storedSpittle = 
                new Spittle(nextSpittleId, spittleToSave);
        spittleStore.put(nextSpittleId,storedSpittle);
        nextSpittleId++;
        return storedSpittle.getId();
    }

}
