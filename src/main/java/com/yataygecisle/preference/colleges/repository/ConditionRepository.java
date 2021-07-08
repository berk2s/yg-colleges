package com.yataygecisle.preference.colleges.repository;

import com.yataygecisle.preference.colleges.domain.Condition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConditionRepository extends JpaRepository<Condition, UUID> {
}
