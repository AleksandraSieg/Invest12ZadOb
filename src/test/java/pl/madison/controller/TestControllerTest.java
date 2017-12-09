package pl.madison.controller;

import org.junit.Test;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.madison.dao.InvestmentDao;
import pl.madison.domain.Investment;
import pl.madison.services.IInvestmentService;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class TestControllerTest {

    @InjectMocks
    private TestController testController;

    @Mock
    private InvestmentDao investmentDao;

    @Mock
    private IInvestmentService iInvestmentService;

    private MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Test
    public void check_if_showMustGoOn_runs() throws Exception {
        List<Investment> investmentList = Arrays.asList(Investment.builder().deposityValue(300).build());
        when(iInvestmentService.findAll()).thenReturn(investmentList);
        mockMvc.perform(get("/showMustGoOn")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].deposityValue").value("300"));


    }

    @Test
    public void theHighest() throws Exception {
        Investment inv1 = Investment.builder().id(1L).deposityValue(300).build();
        Investment inv2 = Investment.builder().id(2L).deposityValue(500).build();

        List<Investment> investmentList = Arrays.asList(inv1, inv2);

        when(iInvestmentService.findOne(2L)).thenReturn(inv2);
        mockMvc.perform(get("/theHighestInvestment"))
                .andExpect(jsonPath("$[1].deposityValue").value("500"));


    }

    @Test
    public void theLowest() throws Exception {
        Investment inv1 = Investment.builder().id(1L).deposityValue(300).build();
        Investment inv2 = Investment.builder().id(2L).deposityValue(500).build();

        List<Investment> investmentList = new ArrayList<Investment>();
        investmentList.add(inv1);
        investmentList.add(inv2);

        when(iInvestmentService.findOne(1L)).thenReturn(inv1);
        mockMvc.perform(get("/theLowestInvestment"))
                .andExpect(jsonPath("$[0].deposityValue").value("300"));


    }

    @Test
    public void update() throws Exception {
        when(iInvestmentService.findOne(2L)).thenReturn(Investment.builder().id(2L).deposityValue(300).build());
        mockMvc.perform(MockMvcRequestBuilders.put("/update").param("id","3")
                .param("deposityValue", "300")).andExpect(MockMvcResultMatchers.content()
                .string("Update completed ^^"));

    }

    @Test
    public void delete() throws Exception {
        when(iInvestmentService.findOne(1L)).thenReturn(Investment.builder().id(1L).build());
        mockMvc.perform(MockMvcRequestBuilders.delete("/delete")
                .param("id","1")).andExpect(MockMvcResultMatchers.content()
                .string("Deleting completed ^^"));

    }

    @Test
    public void add() throws Exception {
        when(iInvestmentService.save(Investment.builder().deposityValue(400).build())).thenReturn(Investment.builder().id(1L).build());
        mockMvc.perform(MockMvcRequestBuilders.put("/add")
                .param("id","1").param("deposityValue", "400"))
                .andExpect(MockMvcResultMatchers.content()
                .string("Adding completed :)"));
    }

}