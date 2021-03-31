package com.country.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CountryDao extends JpaRepository<Country, Long>, JpaSpecificationExecutor {
  Country findByName(String name);
}
