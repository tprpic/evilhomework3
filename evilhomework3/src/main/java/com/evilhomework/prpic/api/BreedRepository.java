package com.evilhomework.prpic.api;

import com.evilhomework.prpic.objects.Breed;

import java.sql.SQLException;
import java.util.List;

public interface BreedRepository {

    public Boolean addBreed (String breedName) throws SQLException;

    public List<Breed> loadBreeds() throws SQLException;

}
