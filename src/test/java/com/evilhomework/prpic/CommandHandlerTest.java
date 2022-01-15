package com.evilhomework.prpic;

import com.evilhomework.prpic.api.BreedService;
import com.evilhomework.prpic.api.DogService;
import com.evilhomework.prpic.exception.ValidationException;
import com.evilhomework.prpic.reports.BreedReport;
import com.evilhomework.prpic.reports.DogReport;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void  listDogsSuccessfully() throws SQLException{
        commandHandler.getCommand("list dogs");
        verify(dogService.findDogs());
    }

}

//prethodni branch test
//za commit na novi branch