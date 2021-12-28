package com.evilhomework.prpic;

import com.evilhomework.prpic.objects.Breed;
import com.evilhomework.prpic.reports.BreedReport;
import com.evilhomework.prpic.reports.DogReport;
import com.evilhomework.prpic.repository.BreedDbParser;
import com.evilhomework.prpic.repository.BreedRepositoryImpl;
import com.evilhomework.prpic.repository.DogDbParser;
import com.evilhomework.prpic.repository.DogRepositoryImpl;
import com.evilhomework.prpic.service.BreedServiceImpl;
import com.evilhomework.prpic.service.DogServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String... args) throws SQLException, ClassNotFoundException {

        var connection = new ConnectionManager().getConnection();

        var commandHandler = new CommandHandler(
                new DogServiceImpl(new DogRepositoryImpl(connection, new DogDbParser())),
                new BreedServiceImpl(new BreedRepositoryImpl(connection, new BreedDbParser())),
                new DogReport(),
                new BreedReport()
        );


        Scanner skener = new Scanner(System.in);

        String command;
        do {
            System.out.println("What do you want to do?");
            command = skener.nextLine();
            commandHandler.getCommand(command);
        } while (!(command.equals("quit")));

    }
}
// comment added by one user

// comment added by other user