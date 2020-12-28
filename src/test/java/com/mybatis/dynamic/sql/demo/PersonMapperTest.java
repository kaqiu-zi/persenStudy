/*
 *    Copyright 2016-2020 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.mybatis.dynamic.sql.demo;

import com.mybatis.dynamic.entity.LastName;
import com.mybatis.dynamic.entity.PersonRecord;
import com.mybatis.dynamic.mapper.PersonMapper;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;

import java.util.List;
import java.util.Optional;

import static com.mybatis.dynamic.entity.PersonDynamicSqlSupport.employed;
import static com.mybatis.dynamic.entity.PersonDynamicSqlSupport.firstName;
import static com.mybatis.dynamic.entity.PersonDynamicSqlSupport.id;
import static com.mybatis.dynamic.entity.PersonDynamicSqlSupport.lastName;
import static com.mybatis.dynamic.entity.PersonDynamicSqlSupport.occupation;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isGreaterThan;
import static org.mybatis.dynamic.sql.SqlBuilder.isIn;
import static org.mybatis.dynamic.sql.SqlBuilder.isLike;
import static org.mybatis.dynamic.sql.SqlBuilder.isNotLike;
import static org.mybatis.dynamic.sql.SqlBuilder.isNull;

class PersonMapperTest {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/SimpleTable?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
    // "jdbc:hsqldb:mem:aname"
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    private SqlSessionFactory sqlSessionFactory;

    @BeforeEach
    void setup() throws Exception {
        Class.forName(JDBC_DRIVER);
//        InputStream is = getClass().getResourceAsStream("/examples/simple/CreateSimpleDB.sql");
//        try (Connection connection = DriverManager.getConnection(JDBC_URL, "root", "adminA123!")) {
//            ScriptRunner sr = new ScriptRunner(connection);
//            sr.setLogWriter(null);
//            sr.runScript(new InputStreamReader(is));
//        }

        UnpooledDataSource ds = new UnpooledDataSource(JDBC_DRIVER, JDBC_URL, "root", "adminA123!");
        Environment environment = new Environment("test", new JdbcTransactionFactory(), ds);
        Configuration config = new Configuration(environment);
        config.addMapper(PersonMapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
    }

    @Test
    void testSelect() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);

            List<PersonRecord> rows = mapper.select(c ->
                    c.where(id, isEqualTo(1))
                    .or(occupation, isNull()));

            assertThat(rows).hasSize(3);
        }
    }

    @Test
    void testSelectAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);

            List<PersonRecord> rows = mapper.select(SelectDSLCompleter.allRows());

            assertThat(rows).hasSize(6);
            assertThat(rows.get(0).getId()).isEqualTo(1);
            assertThat(rows.get(5).getId()).isEqualTo(6);
        }
    }

    @Test
    void testSelectAllOrdered() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);

            List<PersonRecord> rows = mapper
                    .select(SelectDSLCompleter.allRowsOrderedBy(lastName.descending(), firstName.descending()));

            assertThat(rows).hasSize(6);
            assertThat(rows.get(0).getId()).isEqualTo(5);
            assertThat(rows.get(5).getId()).isEqualTo(1);
        }
    }

    @Test
    void testSelectDistinct() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);

            List<PersonRecord> rows = mapper.selectDistinct(c ->
                    c.where(id, isGreaterThan(1))
                    .or(occupation, isNull()));

            assertThat(rows).hasSize(5);
        }
    }

    @Test
    void testSelectWithTypeHandler() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);

            List<PersonRecord> rows = mapper.select(c ->
                    c.where(employed, isEqualTo(false))
                    .orderBy(id));

            assertAll(
                    () -> assertThat(rows).hasSize(2),
                    () -> assertThat(rows.get(0).getId()).isEqualTo(3),
                    () -> assertThat(rows.get(1).getId()).isEqualTo(6)
            );
        }
    }

    @Test
    void testSelectByPrimaryKeyWithMissingRecord() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);

            Optional<PersonRecord> record = mapper.selectByPrimaryKey(300);
            assertThat(record).isNotPresent();
        }
    }

    @Test
    void testFirstNameIn() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);

            List<PersonRecord> rows = mapper.select(c ->
                    c.where(firstName, isIn("Fred", "Barney")));

            assertAll(
                    () -> assertThat(rows).hasSize(2),
                    () -> assertThat(rows.get(0).getLastName().getName()).isEqualTo("Flintstone"),
                    () -> assertThat(rows.get(1).getLastName().getName()).isEqualTo("Rubble")
            );
        }
    }


    @Test
    void testTypeHandledLike() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);

            List<PersonRecord> rows = mapper.select(c ->
                    c.where(lastName, isLike(LastName.of("Fl%")))
                    .orderBy(id));

            assertThat(rows).hasSize(3);
            assertThat(rows.get(0).getFirstName()).isEqualTo("Fred");
        }
    }

    @Test
    void testTypeHandledNotLike() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);

            List<PersonRecord> rows = mapper.select(c ->
                    c.where(lastName, isNotLike(LastName.of("Fl%")))
                    .orderBy(id));

            assertThat(rows).hasSize(3);
            assertThat(rows.get(0).getFirstName()).isEqualTo("Barney");
        }
    }
}
