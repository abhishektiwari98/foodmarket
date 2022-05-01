package com.foodmarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "food_des")
public class FoodDescription {
    @Id
    @Column(name="ndb_no")
    private String databankNumber;

    @Column(name="fdgrp_cd")
    private String foodGroupCode;

    @Column(name="long_desc")
    private String longDescription;

    @Column(name="shrt_desc")
    private String shortDescription;

    @Column(name="comname")
    private String commonName;

    @Column(name="manufacname")
    private String manufacturer;

    @Column(name="survey")
    private String survey;

    @Column(name="ref_desc")
    private String referenceDescription;

    @Column(name="refuse", columnDefinition = "NUMERIC(2)")
    private Integer refuse;

    @Column(name="sciname")
    private String scientificName;

    @Column(name="n_factor", columnDefinition = "NUMERIC(4,2)")
    private Double nitrogenFactor;

    @Column(name="pro_factor", columnDefinition = "NUMERIC(4,2)")
    private Double proteinFactor;

    @Column(name="fat_factor", columnDefinition = "NUMERIC(4,2)")
    private Double fatFactor;

    @Column(name="cho_factor", columnDefinition = "NUMERIC(4,2)")
    private Double carbFactor;

    public String getDatabankNumber() {
        return databankNumber;
    }

    public void setDatabankNumber(String databankNumber) {
        this.databankNumber = databankNumber;
    }

    public String getFoodGroupCode() {
        return foodGroupCode;
    }

    public void setFoodGroupCode(String foodGroupCode) {
        this.foodGroupCode = foodGroupCode;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSurvey() {
        return survey;
    }

    public void setSurvey(String survey) {
        this.survey = survey;
    }

    public String getReferenceDescription() {
        return referenceDescription;
    }

    public void setReferenceDescription(String referenceDescription) {
        this.referenceDescription = referenceDescription;
    }

    public Integer getRefuse() {
        return refuse;
    }

    public void setRefuse(Integer refuse) {
        this.refuse = refuse;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public Double getNitrogenFactor() {
        return nitrogenFactor;
    }

    public void setNitrogenFactor(Double nitrogenFactor) {
        this.nitrogenFactor = nitrogenFactor;
    }

    public Double getProteinFactor() {
        return proteinFactor;
    }

    public void setProteinFactor(Double proteinFactor) {
        this.proteinFactor = proteinFactor;
    }

    public Double getFatFactor() {
        return fatFactor;
    }

    public void setFatFactor(Double fatFactor) {
        this.fatFactor = fatFactor;
    }

    public Double getCarbFactor() {
        return carbFactor;
    }

    public void setCarbFactor(Double carbFactor) {
        this.carbFactor = carbFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodDescription that = (FoodDescription) o;
        return Objects.equals(databankNumber, that.databankNumber) &&
                Objects.equals(foodGroupCode, that.foodGroupCode) &&
                Objects.equals(longDescription, that.longDescription) &&
                Objects.equals(shortDescription, that.shortDescription) &&
                Objects.equals(commonName, that.commonName) &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(survey, that.survey) &&
                Objects.equals(referenceDescription, that.referenceDescription) &&
                Objects.equals(refuse, that.refuse) &&
                Objects.equals(scientificName, that.scientificName) &&
                Objects.equals(nitrogenFactor, that.nitrogenFactor) &&
                Objects.equals(proteinFactor, that.proteinFactor) &&
                Objects.equals(fatFactor, that.fatFactor) &&
                Objects.equals(carbFactor, that.carbFactor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(databankNumber, foodGroupCode, longDescription, shortDescription, commonName, manufacturer, survey, referenceDescription, refuse, scientificName, nitrogenFactor, proteinFactor, fatFactor, carbFactor);
    }

    @Override
    public String toString() {
        return "FoodDescription{" +
                "databankNumber='" + databankNumber + '\'' +
                ", foodGroupCode='" + foodGroupCode + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", commonName='" + commonName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", survey='" + survey + '\'' +
                ", referenceDescription='" + referenceDescription + '\'' +
                ", refuse=" + refuse +
                ", scientificName='" + scientificName + '\'' +
                ", nitrogenFactor=" + nitrogenFactor +
                ", proteinFactor=" + proteinFactor +
                ", fatFactor=" + fatFactor +
                ", carbFactor=" + carbFactor +
                '}';
    }
}
