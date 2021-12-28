package com.evilhomework.prpic.repository;

import com.evilhomework.prpic.objects.Dog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogDbParser {

    public List<Dog> parseResult(ResultSet resultSet) throws SQLException {
        List<Dog> dogs = new ArrayList<>();
        while(resultSet.next()) {
            dogs.add(new Dog(resultSet.getString(1),  resultSet.getInt(2), resultSet.getString(3)));
        }
        return dogs;
    }
}
