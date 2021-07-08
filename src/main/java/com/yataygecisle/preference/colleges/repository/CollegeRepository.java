package com.yataygecisle.preference.colleges.repository;

import com.yataygecisle.preference.colleges.domain.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CollegeRepository extends JpaRepository<College, UUID> {
}
