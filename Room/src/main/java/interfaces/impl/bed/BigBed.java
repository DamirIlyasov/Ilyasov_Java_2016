package interfaces.impl.bed;

import interfaces.Bed;
import org.springframework.stereotype.Component;

@Component
public class BigBed implements Bed {
    private int size;

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}
