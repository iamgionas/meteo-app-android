package ch.supsi.dti.isin.meteoapp.model.apirequest;

import java.util.UUID;

import ch.supsi.dti.isin.meteoapp.model.apirequest.Coordinate;

public class Location {
    private UUID Id;
    private String mName;
    private Coordinate coord;
    private String country;

    public UUID getId() {
        return Id;
    }

    public Location(String mName) {
        Id = UUID.randomUUID();
        this.mName = mName;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Location() {
        Id = UUID.randomUUID();
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + getId().toString() +
                ", name='" + getName() + '\'' +
                ", coord=" + coord.getLat() + "/" + coord.getLon() +
                ", country='" + country + '\'' +
                '}';
    }
}