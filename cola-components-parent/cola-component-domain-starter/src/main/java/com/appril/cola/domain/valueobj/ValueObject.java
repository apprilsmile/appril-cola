package com.appril.cola.domain.valueobj;

public class ValueObject<ID> {
    public ValueObject() {
    }

    public ValueObject(ID id) {
        this.id = id;
    }

    protected ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
