package com.network.model.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class FileDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    public static final File file = new File();

    /**
     * Database Column Remarks:
     *   自增ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: file.id")
    public static final SqlColumn<Long> id = file.id;

    /**
     * Database Column Remarks:
     *   用户id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: file.user_id")
    public static final SqlColumn<Long> userId = file.userId;

    /**
     * Database Column Remarks:
     *   文件名
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: file.filename")
    public static final SqlColumn<String> filename = file.filename;

    /**
     * Database Column Remarks:
     *   目标url
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: file.target_url")
    public static final SqlColumn<String> targetUrl = file.targetUrl;

    /**
     * Database Column Remarks:
     *   文件类型
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: file.file_type")
    public static final SqlColumn<String> fileType = file.fileType;

    /**
     * Database Column Remarks:
     *   文件夹id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: file.folder_id")
    public static final SqlColumn<Long> folderId = file.folderId;

    /**
     * Database Column Remarks:
     *   文件大小
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: file.size")
    public static final SqlColumn<Long> size = file.size;

    /**
     * Database Column Remarks:
     *   md5文件加密码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: file.hash")
    public static final SqlColumn<Long> hash = file.hash;

    /**
     * Database Column Remarks:
     *   状态，0=未启用，1=正常
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: file.status")
    public static final SqlColumn<Byte> status = file.status;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: file.created")
    public static final SqlColumn<LocalDateTime> created = file.created;

    /**
     * Database Column Remarks:
     *   更新时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: file.updated")
    public static final SqlColumn<LocalDateTime> updated = file.updated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: file")
    public static final class File extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<String> filename = column("filename", JDBCType.VARCHAR);

        public final SqlColumn<String> targetUrl = column("target_url", JDBCType.VARCHAR);

        public final SqlColumn<String> fileType = column("file_type", JDBCType.VARCHAR);

        public final SqlColumn<Long> folderId = column("folder_id", JDBCType.BIGINT);

        public final SqlColumn<Long> size = column("`size`", JDBCType.BIGINT);

        public final SqlColumn<Long> hash = column("hash", JDBCType.BIGINT);

        public final SqlColumn<Byte> status = column("`status`", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> created = column("created", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updated = column("updated", JDBCType.TIMESTAMP);

        public File() {
            super("file");
        }
    }
}