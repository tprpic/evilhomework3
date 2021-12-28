package com.evilhomework.prpic.repository;

import com.evilhomework.prpic.Dog;
import com.evilhomework.prpic.api.DogRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DogRepositoryImpl implements DogRepository {
    private final Connection connection;

    public DogRepositoryImpl(Connection connection) {

        this.connection = connection;
    }

    public List<Dog> loadDogs() throws SQLException {

        var preparedStatement = connection.prepareStatement("select * from dog d");
        preparedStatement.execute();
        var result = preparedStatement.getResultSet();

        return new DogDbParser().parseResult(result);
    }

    public Boolean addDog(String dogName, int dogAge, int dogBreedID) throws SQLException{

        var preparedStatement= connection.prepareStatement("insert into dog "); //nedovrseni statementi
        preparedStatement.execute();

        return true;
    }

    public Boolean deleteDog(Long id) throws SQLException {
        var preparedStatement = connection.prepareStatement("delete from dog where id = " + id);

        preparedStatement.execute();

        return true;
    }
}
