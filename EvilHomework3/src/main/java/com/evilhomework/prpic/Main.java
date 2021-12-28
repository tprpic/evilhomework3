package com.evilhomework.prpic;

import com.evilhomework.prpic.repository.BreedRepositoryImpl;
import com.evilhomework.prpic.repository.DogRepositoryImpl;
import com.evilhomework.prpic.service.BreedServiceImpl;
import com.evilhomework.prpic.service.DogServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String... args) throws SQLException, ClassNotFoundException {

        var connection = new ConnectionManager().getConnection();

        var commandHandler = new CommandHandler(
                new DogServiceImpl(new DogRepositoryImpl(connection)),
                new BreedServiceImpl(new BreedRepositoryImpl(connection))
        );


        Scanner skener= new Scanner(System.in);

        String command;
        do{
            System.out.println("What do you want to do?");
            command= skener.nextLine();
            commandHandler.getCommand(command);
        } while(!(command.equals("quit")));






        /*var dogs = dogService.findDogs("R");

        for (Dog dog: dogs) {
            System.out.println("dog name: " + dog.getName());
            System.out.println("dog age: " + dog.getAge());
            System.out.println("dog breed: " + dog.getBreed());
            System.out.println();
        }*/
    }
}
