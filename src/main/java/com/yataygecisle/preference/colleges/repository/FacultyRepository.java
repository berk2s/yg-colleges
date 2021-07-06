package com.yataygecisle.preference.colleges.repository;

import com.yataygecisle.preference.colleges.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FacultyRepository extends JpaRepository<Faculty, UUID> {
}
