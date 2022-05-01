package com.foodmarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "fd_group")
public class FoodGroup {
    @Id
    @Column(name="fdgrp_cd")
    private String groupCode;

    @Column(name="fdgrp_desc")
    private String groupDescription;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodGroup foodGroup = (FoodGroup) o;
        return Objects.equals(groupCode, foodGroup.groupCode) &&
                Objects.equals(groupDescription, foodGroup.groupDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupCode, groupDescription);
    }

    @Override
    public String toString() {
        return "FoodGroup{" +
                "groupCode='" + groupCode + '\'' +
                ", groupDescription='" + groupDescription + '\'' +
                '}';
    }
}
