package com.evilhomework.prpic.repository;

import com.evilhomework.prpic.objects.Dog;
import com.evilhomework.prpic.api.DogRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DogRepositoryImpl implements DogRepository {
    private final Connection connection;
    private final DogDbParser dogParser;


    public DogRepositoryImpl(Connection connection, DogDbParser dogParser) {

        this.connection = connection;
        this.dogParser = dogParser;

    }

    public List<Dog> loadDogs() throws SQLException {

        var preparedStatement = connection.prepareStatement("select d.dog_name, d.dog_age, " +
                        "b.breed_name from dogs d join breeds b on d.breed_id= b.breed_id;");
        preparedStatement.execute();
        var result = preparedStatement.getResultSet();

        return dogParser.parseResult(result);
    }

    public Boolean addDog(String dogName, int dogAge, int dogBreedID) throws SQLException{

        var preparedStatement= connection.prepareStatement("insert into dogs (dog_name, dog_age, " +
                "breed_id) values ('"+ dogName + "', '" + dogAge + "', '" + dogBreedID + "');" );
        preparedStatement.execute();

        return true;
    }

    public Boolean deleteDog(int id) throws SQLException {
        var preparedStatement = connection.prepareStatement("delete from dogs where dog_id = '" + id + "';");

        preparedStatement.execute();

        return true;
    }
}
