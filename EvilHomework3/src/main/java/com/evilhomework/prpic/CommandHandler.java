package com.evilhomework.prpic;

import com.evilhomework.prpic.api.BreedService;
import com.evilhomework.prpic.api.DogService;
import com.evilhomework.prpic.reports.DogReport;

import java.sql.SQLException;

public class CommandHandler {

    private final DogService dogService;
    private final BreedService breedService;

    public CommandHandler(DogService dogService, BreedService breedService) {
        this.dogService = dogService;
        this.breedService = breedService;
    }

    public void getCommand(String command) throws SQLException {

        String[] arrCommand = command.split(" ", 5);

        String firstPartOfTheCommand = arrCommand[0] + arrCommand[1];

        switch (firstPartOfTheCommand) {

            case "add dog":
                var dogAge= Integer.parseInt(arrCommand[3]);
                var dogBreedID= Integer.parseInt(arrCommand[4]);

                if(arrCommand[2].isEmpty() || dogAge==0 || dogBreedID==0){
                    System.out.println("Wrong input. add dog [name] [age] [breedID]");
                    break;
                }else {
                    dogService.addDog(arrCommand[2], dogAge, dogBreedID);
                    System.out.println("Dog has been added to the database.");
                    break;
                }

            case "add breed":
                var breedName= arrCommand[2];
                if(breedName.isEmpty()) {
                    System.out.println("Wrong input. add breed [name]");
                    break;
                }
                else{
                    breedService.addBreed(breedName);
                    System.out.println("Breed has been added to the database.");
                }
                break;

            case "list dogs":
                DogReport dogRep = new DogReport();
                System.out.println(dogRep.dogReport(dogService.findDogs()));
                break;

            case "list breeds":

            case "delete dog":

        }


    }

}
