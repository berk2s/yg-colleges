package com.yataygecisle.preference.colleges.repository;

import com.yataygecisle.preference.colleges.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {
}
