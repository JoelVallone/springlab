package org.digitalpanda.springlab.data;

import java.util.List;

import org.digitalpanda.springlab.spittr.Spittle;
import org.springframework.stereotype.Repository;

@Repository
public interface ISpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long spittleId);    
    Long save(Spittle newSpittle);
}
