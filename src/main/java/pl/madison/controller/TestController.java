package pl.madison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.madison.dao.InvestmentDao;
import pl.madison.domain.Investment;
import pl.madison.services.IInvestmentService;

import java.util.List;

@RestController
public class TestController {

//    @Autowired
//    InvestmentDao investmentDao;

    @Autowired
    IInvestmentService iInvestmentService;

    @RequestMapping(value = "/showMustGoOn", method = RequestMethod.GET)
    public List<Investment> showMustGoOn(){
        return (List<Investment>)iInvestmentService.findAll();


    }

    @RequestMapping(value = "/theHighestInvestment", method = RequestMethod.GET)
    public String theHighest(){
        Investment investTemp = iInvestmentService.findOne(1L);


        for (Investment investment : iInvestmentService.findAll()) {
            if(investTemp.getDeposityValue()<investment.getDeposityValue()){
                investTemp = investment;
            }
        }

        return "the highest investment is: "+investTemp.getDeposityValue();
    }

    @RequestMapping(value = "/theLowestInwestment", method = RequestMethod.GET)
    public String theLowest(){
        Investment investTemp = iInvestmentService.findOne(1L);

        for (Investment investment : iInvestmentService.findAll()) {
            if(investTemp.getDeposityValue()>investment.getDeposityValue()){
                investTemp = investment;
            }
        }

        return "the lowest investment is: "+investTemp.getDeposityValue();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestParam("id") Long id, @RequestParam("deposityValue") int deposityValue){
        Investment investTemp = Investment.builder().id(id).build();
      //  Investment investTemp = investmentDao.findOne(id);
        investTemp.setDeposityValue(deposityValue);
        iInvestmentService.save(investTemp);

        return "Update completed ^^";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") Long id){
        iInvestmentService.delete(id);

        return "Deleting completed ^^";
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public String add(@RequestParam("deposityValue") int deposityValue){
//        Investment investTemp = new Investment();
//        investTemp.setDeposityValue(deposityValue);
//        investmentDao.save(investTemp);

        return "Adding completed :)";
    }
}
