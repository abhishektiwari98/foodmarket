package com.foodmarket.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WeightId implements Serializable {
    @Column(name="ndb_no")
    private String ndbNumber;

    @Column(name="seq")
    private String sequence;

    public String getNdbNumber() {
        return ndbNumber;
    }

    public void setNdbNumber(String ndbNumber) {
        this.ndbNumber = ndbNumber;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightId weightId = (WeightId) o;
        return Objects.equals(ndbNumber, weightId.ndbNumber) &&
                Objects.equals(sequence, weightId.sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ndbNumber, sequence);
    }

    @Override
    public String toString() {
        return "WeightId{" +
                "ndbNumber='" + ndbNumber + '\'' +
                ", sequence='" + sequence + '\'' +
                '}';
    }
}
