package com.andriiiiiko.countries.repository;

import com.andriiiiiko.countries.model.Country;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends ListCrudRepository<Country, Long> {
}
