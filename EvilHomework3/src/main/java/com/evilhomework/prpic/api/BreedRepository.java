package com.evilhomework.prpic.api;

import com.evilhomework.prpic.Breed;

import java.sql.SQLException;
import java.util.List;

public interface BreedRepository {

    public Boolean addBreed (String breedName);

    public List<Breed> loadBreeds() throws SQLException;

}
