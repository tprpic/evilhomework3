package com.evilhomework.prpic.api;

import com.evilhomework.prpic.Breed;

import java.sql.SQLException;
import java.util.List;

public interface BreedService {

    public List<Breed> findBreeds () throws SQLException;

    public Boolean addBreed(String breedName);

}
