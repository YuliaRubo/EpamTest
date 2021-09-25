package com.company;

import java.util.List;

public class StarSystem {
    private String name;
    private List<Star> star;

    public void setStar(List<Star> star) {
        this.star = star;
    }

    public String getName() {
        return name;
    }

    public StarSystem(String name, List<Star> star) {
        this.name = name;
        this.star = star;
    }

    @Override
    public String toString() {
        return "StarSystem{" +
                "name='" + name + '\'' +
                ", star=" + star +
                '}';
    }
}
