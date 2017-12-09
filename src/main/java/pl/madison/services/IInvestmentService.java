package pl.madison.services;

import pl.madison.domain.Investment;

import java.util.List;

public interface IInvestmentService {
    List<Investment> findAll();
    Investment findOne(Long id);
    Investment save(Investment investment);
    void delete(Long id);
}
