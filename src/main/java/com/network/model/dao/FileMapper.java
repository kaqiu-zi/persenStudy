package com.network.model.dao;

import static com.network.model.dao.FileDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.network.model.entity.File;
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
public interface FileMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<File> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("FileResult")
    File selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="FileResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="filename", property="filename", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_url", property="targetUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_type", property="fileType", jdbcType=JdbcType.VARCHAR),
        @Result(column="folder_id", property="folderId", jdbcType=JdbcType.BIGINT),
        @Result(column="size", property="size", jdbcType=JdbcType.BIGINT),
        @Result(column="hash", property="hash", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP)
    })
    List<File> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(file);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, file);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, file)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    default int insert(File record) {
        return insert(SqlBuilder.insert(record)
                .into(file)
                .map(userId).toProperty("userId")
                .map(filename).toProperty("filename")
                .map(targetUrl).toProperty("targetUrl")
                .map(fileType).toProperty("fileType")
                .map(folderId).toProperty("folderId")
                .map(size).toProperty("size")
                .map(hash).toProperty("hash")
                .map(status).toProperty("status")
                .map(created).toProperty("created")
                .map(updated).toProperty("updated")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    default int insertSelective(File record) {
        return insert(SqlBuilder.insert(record)
                .into(file)
                .map(userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(filename).toPropertyWhenPresent("filename", record::getFilename)
                .map(targetUrl).toPropertyWhenPresent("targetUrl", record::getTargetUrl)
                .map(fileType).toPropertyWhenPresent("fileType", record::getFileType)
                .map(folderId).toPropertyWhenPresent("folderId", record::getFolderId)
                .map(size).toPropertyWhenPresent("size", record::getSize)
                .map(hash).toPropertyWhenPresent("hash", record::getHash)
                .map(status).toPropertyWhenPresent("status", record::getStatus)
                .map(created).toPropertyWhenPresent("created", record::getCreated)
                .map(updated).toPropertyWhenPresent("updated", record::getUpdated)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<File>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, userId, filename, targetUrl, fileType, folderId, size, hash, status, created, updated)
                .from(file);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<File>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, userId, filename, targetUrl, fileType, folderId, size, hash, status, created, updated)
                .from(file);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    default File selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, userId, filename, targetUrl, fileType, folderId, size, hash, status, created, updated)
                .from(file)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(File record) {
        return UpdateDSL.updateWithMapper(this::update, file)
                .set(userId).equalTo(record::getUserId)
                .set(filename).equalTo(record::getFilename)
                .set(targetUrl).equalTo(record::getTargetUrl)
                .set(fileType).equalTo(record::getFileType)
                .set(folderId).equalTo(record::getFolderId)
                .set(size).equalTo(record::getSize)
                .set(hash).equalTo(record::getHash)
                .set(status).equalTo(record::getStatus)
                .set(created).equalTo(record::getCreated)
                .set(updated).equalTo(record::getUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(File record) {
        return UpdateDSL.updateWithMapper(this::update, file)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(filename).equalToWhenPresent(record::getFilename)
                .set(targetUrl).equalToWhenPresent(record::getTargetUrl)
                .set(fileType).equalToWhenPresent(record::getFileType)
                .set(folderId).equalToWhenPresent(record::getFolderId)
                .set(size).equalToWhenPresent(record::getSize)
                .set(hash).equalToWhenPresent(record::getHash)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(created).equalToWhenPresent(record::getCreated)
                .set(updated).equalToWhenPresent(record::getUpdated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    default int updateByPrimaryKey(File record) {
        return UpdateDSL.updateWithMapper(this::update, file)
                .set(userId).equalTo(record::getUserId)
                .set(filename).equalTo(record::getFilename)
                .set(targetUrl).equalTo(record::getTargetUrl)
                .set(fileType).equalTo(record::getFileType)
                .set(folderId).equalTo(record::getFolderId)
                .set(size).equalTo(record::getSize)
                .set(hash).equalTo(record::getHash)
                .set(status).equalTo(record::getStatus)
                .set(created).equalTo(record::getCreated)
                .set(updated).equalTo(record::getUpdated)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    default int updateByPrimaryKeySelective(File record) {
        return UpdateDSL.updateWithMapper(this::update, file)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(filename).equalToWhenPresent(record::getFilename)
                .set(targetUrl).equalToWhenPresent(record::getTargetUrl)
                .set(fileType).equalToWhenPresent(record::getFileType)
                .set(folderId).equalToWhenPresent(record::getFolderId)
                .set(size).equalToWhenPresent(record::getSize)
                .set(hash).equalToWhenPresent(record::getHash)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(created).equalToWhenPresent(record::getCreated)
                .set(updated).equalToWhenPresent(record::getUpdated)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}