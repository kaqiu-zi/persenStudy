package music.service.impl;

import music.common.BusinessException;
import music.service.IFileService;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.LinkedList;

/**
 * {@link IFileService} impl
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/18
 * @since 1.0.0
 */
public class FileServiceImpl implements IFileService {
    private static final FileServiceImpl INSTANCE = new FileServiceImpl();
    private FileServiceImpl() { }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedList<String> read(String path) {
        File file = new File(path);
        LinkedList<String> data = new LinkedList<>();
        try (FileReader fileReader = new FileReader(file);
             final BufferedReader input = new BufferedReader(fileReader)) {
            String str = input.readLine();
            while (null != str) {
                data.add(str);
                str = input.readLine();
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new BusinessException("read fail");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(String path, Collection<String> strings) {
        File file = new File(path);
        try (final FileWriter writer = new FileWriter(file);
             final BufferedWriter out = new BufferedWriter(writer)) {
            for (String string : strings) {
                if (StringUtils.isBlank(string)) {
                    out.newLine();
                } else {
                    out.write(string);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static FileServiceImpl of() {
        return INSTANCE;
    }
}
