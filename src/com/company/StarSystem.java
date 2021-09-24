package com.company;

public class StarSystem {
    private String name;

    public String getName() {
        return name;
    }

    public StarSystem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StarSystem{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
