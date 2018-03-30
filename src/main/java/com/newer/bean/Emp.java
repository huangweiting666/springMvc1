package com.newer.bean;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {
     private Integer empNo;
     @NotEmpty(message = "员工姓名不能为空！")
     private String ename;

     @Past(message = "入职日期不能超过当前日期！")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date hiredate;
     @Min(value = 1000,message = "工资不能低于1000")
     @NumberFormat(pattern = "##,###.##",style = NumberFormat.Style.CURRENCY)
     private Double sal;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }
}
