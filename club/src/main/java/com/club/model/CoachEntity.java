package com.club.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "coach", schema = "gym", catalog = "")
public class CoachEntity implements Serializable {
    private String coachName;
    private int coachLevel;

    @Basic
    @Column(name = "coach_level", nullable = false)
    public int getCoachLevel() {
        return coachLevel;
    }

    public void setCoachLevel(int coachLevel) {
        this.coachLevel = coachLevel;
    }

    @Id
    @Column(name = "coach_name", nullable = false, length = 20)
    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoachEntity that = (CoachEntity) o;
        return Objects.equals(coachName, that.coachName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coachName);
    }
}
