package com.bca.cmt.repository.log;

import com.bca.cmt.model.log.OperationLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationLogsRepository extends JpaRepository<OperationLogs, String> {
}
