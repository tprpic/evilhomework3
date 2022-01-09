package com.evilhomework.prpic;

import com.evilhomework.prpic.api.BreedService;
import com.evilhomework.prpic.api.DogService;
import com.evilhomework.prpic.exception.ValidationException;
import com.evilhomework.prpic.fakes.DogServiceFake;
import com.evilhomework.prpic.reports.BreedReport;
import com.evilhomework.prpic.reports.DogReport;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
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
        when(dogService.addDog(any(), any(), any())).thenReturn(true);

        commandHandler.getCommand("add dog someDogName 5 1");

        verify(dogService).addDog(eq("someDogName"), eq(5), eq(1));
    }

    @Test(expected = ValidationException.class)
    public void verifyAddDogThrowsWhenNameTooShort() throws SQLException {
        commandHandler.getCommand("add dog a 5 1");
    }
}

//test za novi branch