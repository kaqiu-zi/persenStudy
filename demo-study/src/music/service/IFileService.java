package music.service;

import java.util.Collection;
import java.util.LinkedList;

/**
 * 文件相关服务
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/18
 * @since 1.0.0
 */
public interface IFileService {
    /**
     * 读取本地文件
     *
     * @param path 文件路径
     * @return string list
     */
    LinkedList<String> read(String path);

    /**
     * 写入本地文件
     *
     * @param path 生成的目标文件路径，如果已存在则重写之
     * @param strings 要写入的strings
     */
    void write(String path, Collection<String> strings);
}
