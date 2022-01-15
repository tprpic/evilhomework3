package com.evilhomework.prpic;

import com.evilhomework.prpic.api.BreedService;
import com.evilhomework.prpic.api.DogService;
import com.evilhomework.prpic.exception.ValidationException;
import com.evilhomework.prpic.objects.Dog;
import com.evilhomework.prpic.reports.BreedReport;
import com.evilhomework.prpic.reports.DogReport;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class CommandHandlerTest {

    @Mock
    private DogService dogService;

    @Mock
    private BreedService breedService;

    @Mock
    private DogReport dogReport;

    @Mock
    private BreedReport breedReport;


    private CommandHandler commandHandler;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        commandHandler = new CommandHandler(dogService, breedService, dogReport, breedReport);
    }

    @Test
    public void addsDogSuccessfully() throws SQLException {
        when(dogService.addDog(anyString(), anyInt(), anyInt())).thenReturn(true);

        commandHandler.getCommand("add dog someDogName 5 1");

        verify(dogService).addDog(eq("someDogName"),eq(5), eq(1));
    }

    @Test
    public void addsBreedSuccessfully() throws SQLException{
        when(breedService.addBreed(anyString())).thenReturn(true);

        commandHandler.getCommand("add breed someBreedName");

        verify(breedService).addBreed(eq("someBreedName"));
    }

    @Test(expected = ValidationException.class)
    public void verifyAddDogThrowsWhenNameTooShort() throws SQLException {
        commandHandler.getCommand("add dog a 5 1");
    }

    @Test(expected = ValidationException.class)
    public void verifyAddDogThrowsWhenNameTooLong() throws SQLException{
        commandHandler.getCommand("add dog baspredugackoimezajednogpsa 5 1");
    }

    @Test(expected = ValidationException.class)
    public void verifyAddDogThrowsWhenAgeTooLow() throws SQLException{
        commandHandler.getCommand("add dog someDogName -1 1");
    }

    @Test(expected = ValidationException.class)
    public void verifyAddDogThrowsWhenAgeTooHigh() throws SQLException{
        commandHandler.getCommand("add dog someDogName 41 1");
    }

    @Test
    public void  listDogsSuccessfully() throws SQLException{

        List<Dog> dogs= new ArrayList<>();
        dogs.add(new Dog("Dora",5, "Mutt"));
        dogs.add(new Dog("Tomo",5, "Doggo"));
        dogs.add(new Dog("Luka",5, "Doge"));

        when(dogService.findDogs()).thenReturn(dogs);

        commandHandler.getCommand("list dogs");

        verify(dogReport).dogReport(dogs);
    }

    @Test
    public void deleteDogSuccessfully() throws SQLException{
        when(dogService.deleteDog(anyInt())).thenReturn(true);

        commandHandler.getCommand("delete dog 1");

        verify(dogService).deleteDog(1);
    }

}

//prethodni branch test
//za commit na novi branch