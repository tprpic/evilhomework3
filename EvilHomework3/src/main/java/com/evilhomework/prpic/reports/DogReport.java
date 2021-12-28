package com.evilhomework.prpic.reports;

import com.evilhomework.prpic.Dog;

import java.util.List;

public class DogReport {

    public String dogReport(List<Dog> dogs){

        String preparedString = "Dog name\t\tDog age\t\tDog Breed\n";

        for (Dog dog: dogs) {
            preparedString+= dog.getName() + "\t\t" + dog.getAge() + "\t\t" + dog.getBreed() + "\n";
        }

        return preparedString;
    }
}
