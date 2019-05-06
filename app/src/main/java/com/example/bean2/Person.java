package com.example.bean2;

import java.util.List;

/**
 * Author : JinTao Li
 * Create Time : 2019/5/5
 */
public class Person {
    private String name;
    private List<Plan> planList;

    public Person(String name, List<Plan> planList) {
        this.name = name;
        this.planList = planList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }
}
