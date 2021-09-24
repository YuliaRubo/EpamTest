package com.company;

import java.util.List;

public class Star {
    private String name;
    private int mass;
    private List<Planet> planet;

    @Override
    public String toString() {
        return "Star{" +
                "name='" + name + '\'' +
                "mass='" + mass + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setPlanet(List<Planet> planet) {
        this.planet = planet;
    }
}
