package com.mybatis.dynamic.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

/**
 * 任务
 *
 * @author kaqiu-omj
 * @version 1.0 2020/12/23 13:52
 * @since 1.0.0
 */

@Data
public class Task {

    /** 任务数 */
    @DecimalMax(value = "20")
    @DecimalMin(value = "1")
    Integer limit;

    /** 任务类型 */
    @Length(min = 1, max = 16)
    String metrics_type;

    /** 公有/私有 */
    @Length(min = 1, max = 16)
    String visible_type;

    /** 机器描述信息 */
    @Length(max = 50)
    String machine;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getMetrics_type() {
        return metrics_type;
    }

    public void setMetrics_type(String metrics_type) {
        this.metrics_type = metrics_type;
    }

    public String getVisible_type() {
        return visible_type;
    }

    public void setVisible_type(String visible_type) {
        this.visible_type = visible_type;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }
}
