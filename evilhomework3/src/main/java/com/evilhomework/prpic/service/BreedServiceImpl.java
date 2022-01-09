package com.evilhomework.prpic.service;

import com.evilhomework.prpic.objects.Breed;
import com.evilhomework.prpic.api.BreedRepository;
import com.evilhomework.prpic.api.BreedService;
import com.evilhomework.prpic.repository.BreedRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class BreedServiceImpl implements BreedService {

    private final BreedRepository breedRepository;

    public BreedServiceImpl( BreedRepositoryImpl breedRepository){
        this.breedRepository= breedRepository;
    }


    public List<Breed> findBreeds () throws SQLException{
        return breedRepository.loadBreeds();
    }

    public Boolean addBreed(String breedName) throws SQLException{

        if(breedName.isEmpty()){
            System.out.println("Breed name can't be empty.");
        }else {
            breedRepository.addBreed(breedName);
        }

        return true;
    }

}
