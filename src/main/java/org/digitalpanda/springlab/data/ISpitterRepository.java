package org.digitalpanda.springlab.data;

import org.digitalpanda.springlab.spittr.Spitter;

public interface ISpitterRepository {
    public long save(Spitter newSpitter);
    public Spitter findByUsername(String username);
}
