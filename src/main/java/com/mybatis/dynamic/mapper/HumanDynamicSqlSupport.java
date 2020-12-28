package com.mybatis.dynamic.mapper;

import java.sql.JDBCType;
import java.time.LocalDate;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class HumanDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Human human = new Human();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = human.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> firstName = human.firstName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> lastName = human.lastName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDate> birthDate = human.birthDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> employed = human.employed;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> occupation = human.occupation;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> addressId = human.addressId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Human extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> firstName = column("first_name", JDBCType.VARCHAR);

        public final SqlColumn<String> lastName = column("last_name", JDBCType.VARCHAR);

        public final SqlColumn<LocalDate> birthDate = column("birth_date", JDBCType.DATE);

        public final SqlColumn<String> employed = column("employed", JDBCType.VARCHAR);

        public final SqlColumn<String> occupation = column("occupation", JDBCType.VARCHAR);

        public final SqlColumn<Integer> addressId = column("address_id", JDBCType.INTEGER);

        public Human() {
            super("Human");
        }
    }
}