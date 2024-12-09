package com.bca.cmt.model;


import jakarta.persistence.*;

@Entity
@Table(name = "t_employee_performance_rate")
public class EmployeePerfRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer minCondition;
    private Integer maxCondition;
    private Integer rate;

    public Integer getMinCondition() {
        return minCondition;
    }

    public void setMinCondition(Integer minCondition) {
        this.minCondition = minCondition;
    }

    public Integer getMaxCondition() {
        return maxCondition;
    }

    public void setMaxCondition(Integer maxCondition) {
        this.maxCondition = maxCondition;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
