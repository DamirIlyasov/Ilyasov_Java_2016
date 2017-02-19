package interfaces.impl.bed;

import interfaces.Bed;
import org.springframework.stereotype.Component;

@Component
public class SmallBed implements Bed {
    private int size;
    public SmallBed(){
        this.size =50;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
