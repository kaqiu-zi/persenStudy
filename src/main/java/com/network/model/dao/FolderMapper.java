package com.network.model.dao;

import static com.network.model.dao.FolderDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.network.model.entity.Folder;
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
public interface FolderMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<Folder> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("FolderResult")
    Folder selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="FolderResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="folder_id", property="folderId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Folder> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(folder);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, folder);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, folder)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    default int insert(Folder record) {
        return insert(SqlBuilder.insert(record)
                .into(folder)
                .map(userId).toProperty("userId")
                .map(name).toProperty("name")
                .map(folderId).toProperty("folderId")
                .map(status).toProperty("status")
                .map(created).toProperty("created")
                .map(updated).toProperty("updated")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    default int insertSelective(Folder record) {
        return insert(SqlBuilder.insert(record)
                .into(folder)
                .map(userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(name).toPropertyWhenPresent("name", record::getName)
                .map(folderId).toPropertyWhenPresent("folderId", record::getFolderId)
                .map(status).toPropertyWhenPresent("status", record::getStatus)
                .map(created).toPropertyWhenPresent("created", record::getCreated)
                .map(updated).toPropertyWhenPresent("updated", record::getUpdated)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Folder>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, userId, name, folderId, status, created, updated)
                .from(folder);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Folder>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, userId, name, folderId, status, created, updated)
                .from(folder);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    default Folder selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, userId, name, folderId, status, created, updated)
                .from(folder)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(Folder record) {
        return UpdateDSL.updateWithMapper(this::update, folder)
                .set(userId).equalTo(record::getUserId)
                .set(name).equalTo(record::getName)
                .set(folderId).equalTo(record::getFolderId)
                .set(status).equalTo(record::getStatus)
                .set(created).equalTo(record::getCreated)
                .set(updated).equalTo(record::getUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(Folder record) {
        return UpdateDSL.updateWithMapper(this::update, folder)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(name).equalToWhenPresent(record::getName)
                .set(folderId).equalToWhenPresent(record::getFolderId)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(created).equalToWhenPresent(record::getCreated)
                .set(updated).equalToWhenPresent(record::getUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    default int updateByPrimaryKey(Folder record) {
        return UpdateDSL.updateWithMapper(this::update, folder)
                .set(userId).equalTo(record::getUserId)
                .set(name).equalTo(record::getName)
                .set(folderId).equalTo(record::getFolderId)
                .set(status).equalTo(record::getStatus)
                .set(created).equalTo(record::getCreated)
                .set(updated).equalTo(record::getUpdated)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    default int updateByPrimaryKeySelective(Folder record) {
        return UpdateDSL.updateWithMapper(this::update, folder)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(name).equalToWhenPresent(record::getName)
                .set(folderId).equalToWhenPresent(record::getFolderId)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(created).equalToWhenPresent(record::getCreated)
                .set(updated).equalToWhenPresent(record::getUpdated)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}