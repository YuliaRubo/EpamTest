package com.company;

import java.util.List;

public class StarSystems {
    private String name;
    private List<Star>star;


    public String getName() {
        return name;
    }

    public List<Star> getStar() {
        return star;
    }

    public void setStar(List<Star> star) {
        this.star = star;
    }

    public void setName(String name) {
        this.name = name;
    }
}
