package com.evilhomework.prpic.fakes;

import com.evilhomework.prpic.api.DogService;
import com.evilhomework.prpic.objects.Dog;

import java.sql.SQLException;
import java.util.List;

public class DogServiceFake implements DogService {

    public int findDogTimesCalled = 0;
    public int addDogTimesCalled = 0;

    @Override
    public List<Dog> findDogs() throws SQLException {
        findDogTimesCalled++;
        return null;
    }

    @Override
    public Boolean addDog(String dogName, int dogAge, int dogBreedID) throws SQLException {
        addDogTimesCalled++;
        return true;
    }

    @Override
    public Boolean deleteDog(int dogID) throws SQLException {
        return null;
    }
}
