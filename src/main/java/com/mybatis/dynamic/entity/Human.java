package com.mybatis.dynamic.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.annotation.Generated;

public class Human implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String firstName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String lastName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDate birthDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String employed;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String occupation;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer addressId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Human withId(Integer id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getFirstName() {
        return firstName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Human withFirstName(String firstName) {
        this.setFirstName(firstName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getLastName() {
        return lastName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Human withLastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Human withBirthDate(LocalDate birthDate) {
        this.setBirthDate(birthDate);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getEmployed() {
        return employed;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Human withEmployed(String employed) {
        this.setEmployed(employed);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEmployed(String employed) {
        this.employed = employed == null ? null : employed.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getOccupation() {
        return occupation;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Human withOccupation(String occupation) {
        this.setOccupation(occupation);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getAddressId() {
        return addressId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Human withAddressId(Integer addressId) {
        this.setAddressId(addressId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Human other = (Human) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFirstName() == null ? other.getFirstName() == null : this.getFirstName().equals(other.getFirstName()))
            && (this.getLastName() == null ? other.getLastName() == null : this.getLastName().equals(other.getLastName()))
            && (this.getBirthDate() == null ? other.getBirthDate() == null : this.getBirthDate().equals(other.getBirthDate()))
            && (this.getEmployed() == null ? other.getEmployed() == null : this.getEmployed().equals(other.getEmployed()))
            && (this.getOccupation() == null ? other.getOccupation() == null : this.getOccupation().equals(other.getOccupation()))
            && (this.getAddressId() == null ? other.getAddressId() == null : this.getAddressId().equals(other.getAddressId()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFirstName() == null) ? 0 : getFirstName().hashCode());
        result = prime * result + ((getLastName() == null) ? 0 : getLastName().hashCode());
        result = prime * result + ((getBirthDate() == null) ? 0 : getBirthDate().hashCode());
        result = prime * result + ((getEmployed() == null) ? 0 : getEmployed().hashCode());
        result = prime * result + ((getOccupation() == null) ? 0 : getOccupation().hashCode());
        result = prime * result + ((getAddressId() == null) ? 0 : getAddressId().hashCode());
        return result;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", employed=").append(employed);
        sb.append(", occupation=").append(occupation);
        sb.append(", addressId=").append(addressId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}