package com.company;

import java.util.List;

public class Satellite {
    private String name;
    private int mass;

    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "name='" + name + '\n' +
                ", mass=" + mass +
                '}';
    }

}
