package com.captain.repo;

import com.captain.model.dao.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CurrencyRepository extends CrudRepository<Currency, Long> {
}
