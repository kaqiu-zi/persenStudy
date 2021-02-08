package music.common;

/**
 * {@link }TODO:需要删减，如果不为测试类则增加描述
 *
 * @author mingJie-Ou
 * @version 1.0 2021/2/5
 * @since 1.0.0 TODO:需要跟随版本号
 */
public class BusinessException extends RuntimeException {

    private String message;

    public BusinessException(String message) {
        super(message, null, true, false);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
