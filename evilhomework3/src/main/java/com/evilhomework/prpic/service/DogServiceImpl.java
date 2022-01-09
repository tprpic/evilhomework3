package com.evilhomework.prpic.service;

import com.evilhomework.prpic.objects.Dog;
import com.evilhomework.prpic.api.DogRepository;
import com.evilhomework.prpic.api.DogService;
import com.evilhomework.prpic.repository.DogRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class DogServiceImpl implements DogService {
    private final DogRepository dogRepository;


    public DogServiceImpl(DogRepositoryImpl dogRepository) { this.dogRepository = dogRepository; }

    public List<Dog> findDogs() throws SQLException {
        return dogRepository.loadDogs();
    }

    public Boolean addDog(String dogName, int dogAge, int dogBreedID) throws SQLException{

        if(dogName.length() >= 2 && dogName.length() <= 20 && dogAge <= 40){
            dogRepository.addDog(dogName, dogAge, dogBreedID);
        }

        return true;
    }

    public Boolean deleteDog(int dogID) throws SQLException{

        dogRepository.deleteDog(dogID);

        return true;
    }
}
