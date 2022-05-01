package com.foodmarket.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "weight")
public class Weight {
    @EmbeddedId
    private WeightId weightId;

    @Column(name="amount", columnDefinition = "NUMERIC(6,3)")
    private Double amount;

    @Column(name="msre_desc")
    private String description;

    @Column(name="gm_wgt", columnDefinition = "NUMERIC(7,1)")
    private Double weight;

    @Column(name="num_data_pts", columnDefinition = "NUMERIC(4)")
    private Double numDataPoints;

    @Column(name="std_dev", columnDefinition = "NUMERIC(7,3)")
    private Double stdDev;

    public WeightId getWeightId() {
        return weightId;
    }

    public void setWeightId(WeightId weightId) {
        this.weightId = weightId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getNumDataPoints() {
        return numDataPoints;
    }

    public void setNumDataPoints(Double numDataPoints) {
        this.numDataPoints = numDataPoints;
    }

    public Double getStdDev() {
        return stdDev;
    }

    public void setStdDev(Double stdDev) {
        this.stdDev = stdDev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight1 = (Weight) o;
        return amount == weight1.amount &&
                weight == weight1.weight &&
                numDataPoints == weight1.numDataPoints &&
                stdDev == weight1.stdDev &&
                Objects.equals(weightId, weight1.weightId) &&
                Objects.equals(description, weight1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weightId, amount, description, weight, numDataPoints, stdDev);
    }

    @Override
    public String toString() {
        return "Weight{" +
                "weightId=" + weightId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", numDataPoints=" + numDataPoints +
                ", stdDev=" + stdDev +
                '}';
    }
}
