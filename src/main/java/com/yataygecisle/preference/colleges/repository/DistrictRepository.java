package com.yataygecisle.preference.colleges.repository;

import com.yataygecisle.preference.colleges.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DistrictRepository extends JpaRepository<District, UUID> {
}
