package com.evilhomework.prpic.repository;

import com.evilhomework.prpic.objects.Breed;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BreedDbParser {

    public List<Breed> parseResult(ResultSet resultSet) throws SQLException {
        List<Breed> breeds = new ArrayList<>();
        while(resultSet.next()) {
            breeds.add(new Breed(resultSet.getInt(1), resultSet.getString(2)));
        }
        return breeds;
    }
}
