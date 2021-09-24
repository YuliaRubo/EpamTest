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
                "name='" + name + '\'' +
                ", mass=" + mass +
                '}';
    }
}
