package com.evilhomework.prpic.api;

import com.evilhomework.prpic.objects.Dog;

import java.sql.SQLException;
import java.util.List;

public interface DogService {

    List<Dog> findDogs() throws SQLException;

    Boolean addDog(String dogName, int dogAge, int dogBreedID)throws SQLException;

    Boolean deleteDog(int dogID) throws SQLException;

}
