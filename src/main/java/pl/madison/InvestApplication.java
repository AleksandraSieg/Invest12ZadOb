package pl.madison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.madison.dao.InvestmentDao;
import pl.madison.domain.Investment;

@SpringBootApplication
public class InvestApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(InvestApplication.class, args);
    }

    @Autowired
    InvestmentDao investmentDao;

    public void run(String... strings) throws Exception {
        Investment invest1 = new Investment();
        Investment invest2 = new Investment();
        Investment invest3 = new Investment();
        Investment invest4 = new Investment();

        invest1.setDeposityValue(1000);
        invest2.setDeposityValue(3000);
        invest3.setDeposityValue(5000);
        invest4.setDeposityValue(500);

        investmentDao.save(invest1);
        investmentDao.save(invest2);
        investmentDao.save(invest3);
        investmentDao.save(invest4);
    }
}
