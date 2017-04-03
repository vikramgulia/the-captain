package com.captain.repo;

import com.captain.model.dao.Locale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface LocaleRepository extends CrudRepository<Locale, Long> {
}