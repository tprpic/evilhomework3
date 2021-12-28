package com.evilhomework.prpic.reports;

import com.evilhomework.prpic.objects.Breed;


import java.util.List;

public class BreedReport {

    public String breedReport(List<Breed> breeds){

        String preparedString = "Breed ID\t\tBreed name\n";

        for (Breed breed: breeds) {
            preparedString+= breed.getBreedID() + "\t\t" + breed.getBreedName() + "\n";
        }

        return preparedString;
    }
}
