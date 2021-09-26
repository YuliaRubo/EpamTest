package com.company;

import java.util.List;

public class Planet {
    private String name;
    private int mass;
    private List<Satellite> satellite;

    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\n' +
                ", mass=" + mass +
                ", satellite=" + satellite +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setSatellite(List<Satellite> satellite) {
        this.satellite = satellite;
    }

    public List<Satellite> getSatellites() {
        return satellite;
    }
}
