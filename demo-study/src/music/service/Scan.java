package music.service;

import music.common.BusinessException;
import music.constant.Constants;
import music.entity.MusicScore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * {@link }TODO:需要删减，如果不为测试类则增加描述
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/8
 * @since 1.0.0 TODO:需要跟随版本号
 */
public class Scan {
    public Scan() { }

    public MusicScore scan(String path) {
        File file = new File(path);
        boolean isStaff = false;
        int speed = 0;
        int row = 0;
        try (FileReader fileReader = new FileReader(file);
             final BufferedReader out = new BufferedReader(fileReader);
        ) {
            // 预检测
            final String head = out.readLine();
            if (Constants.JAVA_SCRIPT.equals(head)) {
                throw new BusinessException("头文件被破坏，请检查");
            }
            final String staff = out.readLine();
            if (Constants.STAFF_TRUE.equals(staff)) {
                isStaff = true;
            } else if (!Constants.STAFF_FALSE.equals(staff)) {
                throw new BusinessException("头文件被破坏，请检查");
            }
            // 获取曲速
            final String speedString = out.readLine();
            if (null == speedString) {
                throw new BusinessException("获取曲速失败");
            }
            speed = Integer.parseInt(speedString.substring(Constants.SPEED_TEXT.length()));
            // 获取行数
            final String rowString = out.readLine();
            if (null == rowString) {
                throw new BusinessException("获取行数失败");
            }
            row = Math.min(Integer.parseInt(rowString.substring(Constants.ROWS_TEXT.length())), Constants.MAX_ROWS);
            String[] data = new String[row];
            // 根据行数读取内容，不足时抛出异常
            for (int i = 0; i < row; i++) {
                final String dataString = out.readLine();
                if (null == dataString) {
                    throw new BusinessException("读取内容失败，文件内容不足");
                }
                data[i] = dataString;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
