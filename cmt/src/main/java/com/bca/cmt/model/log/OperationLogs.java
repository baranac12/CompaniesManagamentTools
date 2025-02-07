package com.bca.cmt.model.log;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_operation_logs")
@AllArgsConstructor
@NoArgsConstructor
public class OperationLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "operation_logs_id_seq")
    @SequenceGenerator(name = "operation_logs_id_seq", sequenceName = "operation_logs_id_seq",  allocationSize=1)
    private Long id;

    private LocalDateTime operationTime;
    private String operationName;
    private String errorMethod;
    private String errorDetail;
    private String endPoint;
    private String method;
    private String status;
}
