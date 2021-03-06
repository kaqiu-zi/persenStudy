package com.network.model.dao;

import static com.network.model.dao.UserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.network.model.entity.User;
import java.util.List;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

@Mapper
public interface UserMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<User> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    User selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar_file_id", property="avatarFileId", jdbcType=JdbcType.BIGINT),
        @Result(column="avatar_url", property="avatarUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="capacity", property="capacity", jdbcType=JdbcType.BIGINT),
        @Result(column="footprint", property="footprint", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(user);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, user);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, user)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int insert(User record) {
        return insert(SqlBuilder.insert(record)
                .into(user)
                .map(username).toProperty("username")
                .map(email).toProperty("email")
                .map(password).toProperty("password")
                .map(nickname).toProperty("nickname")
                .map(avatarFileId).toProperty("avatarFileId")
                .map(avatarUrl).toProperty("avatarUrl")
                .map(capacity).toProperty("capacity")
                .map(footprint).toProperty("footprint")
                .map(status).toProperty("status")
                .map(created).toProperty("created")
                .map(updated).toProperty("updated")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int insertSelective(User record) {
        return insert(SqlBuilder.insert(record)
                .into(user)
                .map(username).toPropertyWhenPresent("username", record::getUsername)
                .map(email).toPropertyWhenPresent("email", record::getEmail)
                .map(password).toPropertyWhenPresent("password", record::getPassword)
                .map(nickname).toPropertyWhenPresent("nickname", record::getNickname)
                .map(avatarFileId).toPropertyWhenPresent("avatarFileId", record::getAvatarFileId)
                .map(avatarUrl).toPropertyWhenPresent("avatarUrl", record::getAvatarUrl)
                .map(capacity).toPropertyWhenPresent("capacity", record::getCapacity)
                .map(footprint).toPropertyWhenPresent("footprint", record::getFootprint)
                .map(status).toPropertyWhenPresent("status", record::getStatus)
                .map(created).toPropertyWhenPresent("created", record::getCreated)
                .map(updated).toPropertyWhenPresent("updated", record::getUpdated)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<User>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, username, email, password, nickname, avatarFileId, avatarUrl, capacity, footprint, status, created, updated)
                .from(user);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<User>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, username, email, password, nickname, avatarFileId, avatarUrl, capacity, footprint, status, created, updated)
                .from(user);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default User selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, username, email, password, nickname, avatarFileId, avatarUrl, capacity, footprint, status, created, updated)
                .from(user)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(User record) {
        return UpdateDSL.updateWithMapper(this::update, user)
                .set(username).equalTo(record::getUsername)
                .set(email).equalTo(record::getEmail)
                .set(password).equalTo(record::getPassword)
                .set(nickname).equalTo(record::getNickname)
                .set(avatarFileId).equalTo(record::getAvatarFileId)
                .set(avatarUrl).equalTo(record::getAvatarUrl)
                .set(capacity).equalTo(record::getCapacity)
                .set(footprint).equalTo(record::getFootprint)
                .set(status).equalTo(record::getStatus)
                .set(created).equalTo(record::getCreated)
                .set(updated).equalTo(record::getUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(User record) {
        return UpdateDSL.updateWithMapper(this::update, user)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(nickname).equalToWhenPresent(record::getNickname)
                .set(avatarFileId).equalToWhenPresent(record::getAvatarFileId)
                .set(avatarUrl).equalToWhenPresent(record::getAvatarUrl)
                .set(capacity).equalToWhenPresent(record::getCapacity)
                .set(footprint).equalToWhenPresent(record::getFootprint)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(created).equalToWhenPresent(record::getCreated)
                .set(updated).equalToWhenPresent(record::getUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int updateByPrimaryKey(User record) {
        return UpdateDSL.updateWithMapper(this::update, user)
                .set(username).equalTo(record::getUsername)
                .set(email).equalTo(record::getEmail)
                .set(password).equalTo(record::getPassword)
                .set(nickname).equalTo(record::getNickname)
                .set(avatarFileId).equalTo(record::getAvatarFileId)
                .set(avatarUrl).equalTo(record::getAvatarUrl)
                .set(capacity).equalTo(record::getCapacity)
                .set(footprint).equalTo(record::getFootprint)
                .set(status).equalTo(record::getStatus)
                .set(created).equalTo(record::getCreated)
                .set(updated).equalTo(record::getUpdated)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int updateByPrimaryKeySelective(User record) {
        return UpdateDSL.updateWithMapper(this::update, user)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(nickname).equalToWhenPresent(record::getNickname)
                .set(avatarFileId).equalToWhenPresent(record::getAvatarFileId)
                .set(avatarUrl).equalToWhenPresent(record::getAvatarUrl)
                .set(capacity).equalToWhenPresent(record::getCapacity)
                .set(footprint).equalToWhenPresent(record::getFootprint)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(created).equalToWhenPresent(record::getCreated)
                .set(updated).equalToWhenPresent(record::getUpdated)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}