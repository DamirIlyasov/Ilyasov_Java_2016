package interfaces.impl.chair;

import interfaces.Chair;
import org.springframework.stereotype.Component;


@Component
public class BigChair implements Chair {
    private int size;

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
