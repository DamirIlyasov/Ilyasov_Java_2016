package interfaces.impl.room;

import interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class GuestRoom extends Room {
    @Autowired
    public GuestRoom(@Qualifier("smallBed") Bed bed,@Qualifier("smallChair") Chair chair, @Qualifier("smallTable") Table table, Color color) {
        super(bed, chair, table, color);
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("Комната готова!");
    }
}
