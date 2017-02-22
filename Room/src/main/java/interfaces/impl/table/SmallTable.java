package interfaces.impl.table;

import interfaces.Table;
import org.springframework.stereotype.Component;


@Component
public class SmallTable implements Table {
    private int size;

    public SmallTable() {
        this.size = 50;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
