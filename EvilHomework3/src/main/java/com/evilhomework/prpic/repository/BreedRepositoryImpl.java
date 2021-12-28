package com.evilhomework.prpic.repository;

import com.evilhomework.prpic.Breed;
import com.evilhomework.prpic.api.BreedRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BreedRepositoryImpl implements BreedRepository {
    private final Connection connection;

    public BreedRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Breed> loadBreeds() throws SQLException {

        var preparedStatement = connection.prepareStatement("select * from dog d");
        preparedStatement.execute();
        var result = preparedStatement.getResultSet();

        return new BreedDbParser().parseResult(result);
    }


    public Boolean addBreed(String breedName) {

        return true;
    }
}
