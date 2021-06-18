package com.appril.cola.domain.model;

import com.appril.cola.domain.repository.DataRepository;

public abstract class Entity<ID> {
    public Entity() {
    }

    public Entity(ID id) {
        this.id = id;
    }

    public Entity(String globalId) {
        this.globalId = globalId;
    }

    public Entity(ID id, String globalId) {
        this.id = id;
        this.globalId = globalId;
    }

    /**
     * entity id
     */
    protected ID id;

    /**
     * global id
     */
    protected String globalId;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    protected abstract DataRepository getRepository();

    public int save(String operator) {
        DataRepository repository = getRepository();
        return repository.save(this, operator);
    }
}
