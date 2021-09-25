package com.company;

import java.util.List;

public class StarSystems {
    private String name;
    private List<StarSystem> StarSystems;

    @Override
    public String toString() {
        return "StarSystems{" +
                "name='" + name + '\'' +
                ", StarSystems=" + StarSystems +
                '}';
    }

    public void setStarSystems(List<StarSystem> starSystems) {
        StarSystems = starSystems;
    }

    public String getName() {
        return name;
    }

    public void getStarSystems() {

    }

    public void setName(String name) {
        this.name = name;
    }



}
