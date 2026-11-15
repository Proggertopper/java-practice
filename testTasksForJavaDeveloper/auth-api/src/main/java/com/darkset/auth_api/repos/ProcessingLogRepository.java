package com.darkset.auth_api.repos;

import com.darkset.auth_api.models.ProcessingLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProcessingLogRepository extends JpaRepository<ProcessingLog , UUID> {
}
