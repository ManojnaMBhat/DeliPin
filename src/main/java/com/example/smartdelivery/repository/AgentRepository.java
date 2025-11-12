package com.example.smartdelivery.repository;

import com.example.smartdelivery.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
