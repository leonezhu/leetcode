package stack;

/**
 * @author XiaoXiong
 * @since 2019-11-22
 */
public class StringArrayStack {

    private String[] items;

    private int count;

    private int size;


    public StringArrayStack(int size) {

        this.items = new String[size];
        this.count = 0;
        this.size = size;
    }

    public boolean push(String item) {
        if (count == size) {
            return false;
        }
        items[count] = item;
        ++count;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }

        String tmp = items[count - 1];
        --count;
        return tmp;

    }
}
