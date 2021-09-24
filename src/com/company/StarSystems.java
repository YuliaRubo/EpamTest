package com.company;

import java.util.List;

public class StarSystems {
    private String name;
    private List<StarSystem> StarSystems;


    public void setStarSystems(List<StarSystem> starSystems) {
        StarSystems = starSystems;
    }

    public String getName() {
        return name;
    }

    public void getStarSystems() {
        System.out.println("Масса"+ StarSystems);;

    }

    public void setName(String name) {
        this.name = name;
    }
}
