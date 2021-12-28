package com.evilhomework.prpic.api;

import com.evilhomework.prpic.Dog;

import java.sql.SQLException;
import java.util.List;

public interface DogRepository {

    public List<Dog> loadDogs() throws SQLException;

    public Boolean addDog(String dogName, int dogAge, int dogBreedID)throws SQLException;

}
