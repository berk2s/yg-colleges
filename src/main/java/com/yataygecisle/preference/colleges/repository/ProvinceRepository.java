package com.yataygecisle.preference.colleges.repository;

import com.yataygecisle.preference.colleges.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProvinceRepository extends JpaRepository<Province, UUID> {
}
