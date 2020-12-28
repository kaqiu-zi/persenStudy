package com.mybatis.dynamic.entity;

import org.mybatis.dynamic.sql.SqlColumn;

import java.util.Date;

/**int
 * @author kaqiuzi
 */
public class SimpleTableRecord {
    private SqlColumn<Integer> id;
    private SqlColumn<String> firstName;
    private SqlColumn<String> lastName;
    private SqlColumn<Date> birthDate;
    private SqlColumn<Boolean> employed;
    private SqlColumn<String> occupation;

    public SqlColumn<Integer> getId() {
        return id;
    }

    public void setId(SqlColumn<Integer> id) {
        this.id = id;
    }

    public SqlColumn<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(SqlColumn<String> firstName) {
        this.firstName = firstName;
    }

    public SqlColumn<String> getLastName() {
        return lastName;
    }

    public void setLastName(SqlColumn<String> lastName) {
        this.lastName = lastName;
    }

    public SqlColumn<Date> getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(SqlColumn<Date> birthDate) {
        this.birthDate = birthDate;
    }

    public SqlColumn<Boolean> getEmployed() {
        return employed;
    }

    public void setEmployed(SqlColumn<Boolean> employed) {
        this.employed = employed;
    }

    public SqlColumn<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(SqlColumn<String> occupation) {
        this.occupation = occupation;
    }
}
