package pl.madison.dao;

import org.springframework.data.repository.CrudRepository;
import pl.madison.domain.Investment;

public interface InvestmentDao extends CrudRepository<Investment, Long>{
}
