package com.evilhomework.prpic.repository;

import com.evilhomework.prpic.objects.Breed;
import com.evilhomework.prpic.api.BreedRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BreedRepositoryImpl implements BreedRepository {
    private final Connection connection;
    private final BreedDbParser breedParser;

    public BreedRepositoryImpl(Connection connection, BreedDbParser breedParser) {
        this.connection = connection;
        this.breedParser= breedParser;
    }

    public List<Breed> loadBreeds() throws SQLException {

        var preparedStatement = connection.prepareStatement("select * from breeds");
        preparedStatement.execute();
        var result = preparedStatement.getResultSet();

        return breedParser.parseResult(result);
    }


    public Boolean addBreed(String breedName) throws SQLException{
        var preparedStatement =connection.prepareStatement("insert into breeds (breed_name) values (" +
                "'" + breedName + "');");
        preparedStatement.execute();
        return true;
    }
}
