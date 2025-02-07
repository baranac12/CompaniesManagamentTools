package com.bca.cmt.service.log;

import com.bca.cmt.model.log.OperationLogs;
import com.bca.cmt.repository.log.OperationLogsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
public class LogService {
    final OperationLogsRepository operationLogsRepository;

    public LogService(OperationLogsRepository operationLogsRepository) {
        this.operationLogsRepository = operationLogsRepository;
    }


    public void saveLog(String operationName, String errorMethod, String errorDetail,String endPoint,String method,String status,LocalDateTime date) {

        OperationLogs log = new OperationLogs();
        log.setOperationName(operationName);
        log.setErrorMethod(errorMethod);
        log.setErrorDetail(errorDetail);
        log.setEndPoint(endPoint);
        log.setMethod(method);
        log.setOperationTime(date);
        log.setStatus(status);
        operationLogsRepository.save(log);
    }
    public List<OperationLogs> list() {
        return operationLogsRepository.findAll();
    }
    public void logCreate(JoinPoint joinPoint, Object result,String operationName,String endPoint,String method) {
        String errorMethod = joinPoint.getSignature().toShortString();
        LocalDateTime logDate = LocalDateTime.now();
        String status = null;
        String errorDetail = null;

        if (result instanceof ResponseEntity) {
            ResponseEntity<?> responseEntity = (ResponseEntity<?>) result;
            log.info(responseEntity.getBody().toString(), responseEntity.getStatusCode());
            status = responseEntity.getStatusCode().toString();
            errorDetail = responseEntity.getBody().toString();
        } else {
            status = HttpStatus.OK.toString();
            errorDetail = null;
        }
        saveLog(operationName,errorMethod,errorDetail,endPoint,method,status,logDate);
    }

}
