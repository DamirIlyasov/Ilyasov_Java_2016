package interfaces.impl.table;

import interfaces.Table;
import org.springframework.stereotype.Component;


@Component
public class BigTable implements Table {
    private int size;

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
