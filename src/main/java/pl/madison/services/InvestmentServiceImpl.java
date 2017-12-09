package pl.madison.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.madison.dao.InvestmentDao;
import pl.madison.domain.Investment;

import java.util.List;

@Service
public class InvestmentServiceImpl implements IInvestmentService {
    @Autowired
    private InvestmentDao investmentDao;

    public List<Investment> findAll() {
        return (List<Investment>)investmentDao.findAll();
    }

    public Investment findOne(Long id) {
        return investmentDao.findOne(id);
    }

    public Investment save(Investment investment) {
        return investmentDao.save(investment);
    }

    public void delete(Long id) {
        investmentDao.delete(id);
    }
}
