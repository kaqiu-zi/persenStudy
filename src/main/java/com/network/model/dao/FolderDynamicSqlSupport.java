package com.network.model.dao;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class FolderDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    public static final Folder folder = new Folder();

    /**
     * Database Column Remarks:
     *   自增ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: folder.id")
    public static final SqlColumn<Long> id = folder.id;

    /**
     * Database Column Remarks:
     *   用户id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: folder.user_id")
    public static final SqlColumn<Long> userId = folder.userId;

    /**
     * Database Column Remarks:
     *   文件夹名
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: folder.name")
    public static final SqlColumn<String> name = folder.name;

    /**
     * Database Column Remarks:
     *   所在的文件夹id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: folder.folder_id")
    public static final SqlColumn<Long> folderId = folder.folderId;

    /**
     * Database Column Remarks:
     *   状态，0=未启用，1=正常
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: folder.status")
    public static final SqlColumn<Byte> status = folder.status;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: folder.created")
    public static final SqlColumn<LocalDateTime> created = folder.created;

    /**
     * Database Column Remarks:
     *   更新时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: folder.updated")
    public static final SqlColumn<LocalDateTime> updated = folder.updated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: folder")
    public static final class Folder extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<Long> folderId = column("folder_id", JDBCType.BIGINT);

        public final SqlColumn<Byte> status = column("`status`", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> created = column("created", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updated = column("updated", JDBCType.TIMESTAMP);

        public Folder() {
            super("folder");
        }
    }
}