package com.evilhomework.prpic;

import com.evilhomework.prpic.api.BreedService;
import com.evilhomework.prpic.api.DogService;
import com.evilhomework.prpic.exception.ValidationException;
import com.evilhomework.prpic.reports.BreedReport;
import com.evilhomework.prpic.reports.DogReport;

import java.sql.SQLException;

public class CommandHandler {

    private final DogService dogService;
    private final BreedService breedService;
    private final DogReport dogReport;
    private final BreedReport breedReport;

    public CommandHandler(DogService dogService, BreedService breedService, DogReport dogReport, BreedReport breedReport) {
        this.dogService = dogService;
        this.breedService = breedService;
        this.dogReport = dogReport;
        this.breedReport = breedReport;
    }

    public void getCommand(String command) throws SQLException {

        String[] arrCommand = command.split(" ", 5);
        String firstPartOfTheCommand="";

        try{
            firstPartOfTheCommand = arrCommand[0] + " " + arrCommand[1];
        }catch(Exception e){
            System.out.println("Program will exit now.");
        }

        switch (firstPartOfTheCommand) {

            case "add dog":
                var dogName = arrCommand[2];
                var dogAge = Integer.parseInt(arrCommand[3]);
                var dogBreedID = Integer.parseInt(arrCommand[4]);

                if ((dogName.length() < 2 || dogName.length() > 20) || (dogAge <= 0 || dogAge > 40)  || dogBreedID == 0) {
                    System.out.println("Wrong input. add dog 2<=[name]<=20 0<[age]<=40 [breedID]!=0");
                    throw new ValidationException("Wrong input. add dog 2<=[name]<=20 0<[age]<=40 [breedID]!=0");
                } else {
                    dogService.addDog(arrCommand[2], dogAge, dogBreedID);
                    System.out.println("Dog has been added to the database.");
                    break;
                }

            case "add breed":
                var breedName = arrCommand[2];
                if (breedName.isEmpty()) {
                    System.out.println("Wrong input. add breed [name]");
                    break;
                } else {
                    breedService.addBreed(breedName);
                    System.out.println("Breed has been added to the database.");
                }
                break;

            case "list dogs":
                System.out.println(dogReport.dogReport(dogService.findDogs()));
                break;

            case "list breeds":
                System.out.println(breedReport.breedReport(breedService.findBreeds()));
                break;

            case "delete dog":
                var dogID = Integer.parseInt(arrCommand[2]);
                dogService.deleteDog(dogID);
                System.out.println("Dog with ID- " + dogID + " has been deleted.");
                break;

        }

    }

}
