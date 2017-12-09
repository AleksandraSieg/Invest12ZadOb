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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.madison.dao.InvestmentDao;
import pl.madison.domain.Investment;
import pl.madison.services.IInvestmentService;


import static org.junit.Assert.*;

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
    public void showMustGoOn() throws Exception {

    }

    @Test
    public void theHighest() throws Exception {
    }

    @Test
    public void theLowest() throws Exception {
    }

    @Test
    public void update() throws Exception {
        Mockito.when(iInvestmentService.findOne(3L)).thenReturn(Investment.builder().id(2L).deposityValue(300).build());
        mockMvc.perform(MockMvcRequestBuilders.put("/update").param("id","3")
                .param("deposityValue", "300")).andExpect(MockMvcResultMatchers.content()
                .string("Update completed ^^"));

    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void add() throws Exception {
    }

}