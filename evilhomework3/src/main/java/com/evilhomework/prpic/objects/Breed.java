package com.evilhomework.prpic.objects;

public class Breed {

    private int breedID;
    private String breedName;


    public Breed(int breedID, String breedName) {
        this.breedID = breedID;
        this.breedName = breedName;

    }

    public int getBreedID() {
        return breedID;
    }

    public void setBreedID(int breedID) {
        this.breedID = breedID;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getBreedName() {
        return breedName;
    }

}
