package io.github.lorensfs.models;

public class Funkos {
    String name;
    String description;
    Boolean vaulted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getVaulted() {
        return vaulted;
    }

    public void setVaulted(Boolean vaulted) {
        this.vaulted = vaulted;
    }

    @Override
    public String toString() {
        return "Funkos{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", vaulted=" + vaulted +
                '}';
    }
}
