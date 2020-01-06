package self.search.base.simple;

import lombok.Data;

/**
 * Page
 *
 * @author chenzb
 * @date 2020/1/6
 */
@Data
public class Page {

    public static final int MAX_SPACE = Integer.MAX_VALUE;

    private byte[] data;

    public Page() {
        this.data = new byte[MAX_SPACE];
    }

    public Page(byte[] data) {
        this.data = data;
    }
}
