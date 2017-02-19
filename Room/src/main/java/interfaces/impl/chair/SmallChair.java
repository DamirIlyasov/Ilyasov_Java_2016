package interfaces.impl.chair;

import interfaces.Chair;
import org.springframework.stereotype.Component;


@Component
public class SmallChair implements Chair {
    private int size;

    public SmallChair(){
        this.size = 50;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
