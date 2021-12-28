package com.evilhomework.prpic.api;

import com.evilhomework.prpic.objects.Breed;

import java.sql.SQLException;
import java.util.List;

public interface BreedService {

    public List<Breed> findBreeds () throws SQLException;

    public Boolean addBreed(String breedName)throws  SQLException;

}
