package com.country.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class CountryApplication {

  public static void main(String[] args) {
    SpringApplication.run(CountryApplication.class, args);
  }

  @Autowired
  private CountryDao countryDao;

  @PostConstruct
  public void init() {
    Country countryCa = new Country("Canada", "CA");
    Country countryRu = new Country("Russia", "RU");
    countryDao.save(countryCa);
    countryDao.save(countryRu);

    System.out.println("County by Jpa: ");
    System.out.println(countryDao.findAll().toString());


    Country countryByName = countryDao.findByName("Russia");
    System.out.println("County by Name: ");
    System.out.println(countryByName);


    List<Country> countryBySpecification = countryDao.findAll(
        (root, query, cb) -> cb.equal(root.get("codeName"), "RU"));

    System.out.println("County by Specification: ");
    System.out.println(countryBySpecification);
  }


}
