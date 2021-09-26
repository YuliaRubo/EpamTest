package com.company;

import java.util.List;
import java.util.stream.Stream;

public class StarSystem {
    private String name;
    private List<Star> star;

    public StarSystem() {

    }

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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StarSystem{" +
                "name='" + name + '\n' +
                ", star=" + star +
                '}';
    }

    public List<Star> getStars() {
        return star;
    }

}
