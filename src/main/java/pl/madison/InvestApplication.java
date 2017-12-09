package pl.madison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.madison.dao.InvestmentDao;
import pl.madison.domain.Investment;

import javax.persistence.criteria.CriteriaBuilder;

@SpringBootApplication
public class InvestApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(InvestApplication.class, args);
    }

    @Autowired
    InvestmentDao investmentDao;

//    public Investment createInvestment(int deposityValue){
//        Investment invest = new Investment();
//        invest.setDeposityValue(deposityValue);
//        return invest;
//    }


    public void run(String... strings) throws Exception {
//        Investment invest1 = createInvestment(1000);
//        Investment invest2 = createInvestment(3000);
//        Investment invest3 = createInvestment(10000);
//        Investment invest4 = createInvestment(500);
//
//
//        investmentDao.save(invest1);
//        investmentDao.save(invest2);
//        investmentDao.save(invest3);
//        investmentDao.save(invest4);
    }
}
