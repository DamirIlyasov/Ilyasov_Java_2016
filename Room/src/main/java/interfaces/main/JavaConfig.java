package interfaces.main;

import interfaces.Color;
import interfaces.impl.bed.BigBed;
import interfaces.impl.chair.BigChair;
import interfaces.impl.color.Red;
import interfaces.impl.room.BedRoom;
import interfaces.impl.table.BigTable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("interfaces.impl")
public class JavaConfig {



    @Bean
    public BigBed bigBed(){
        BigBed bigBed = new BigBed();
        bigBed.setSize(110);
        return bigBed;
    }
    @Bean
    public BigChair bigChair(){
        BigChair bigChair = new BigChair();
        bigChair.setSize(110);
        return bigChair;
    }
    @Bean
    public BigTable bigTable(){
        BigTable bigTable = new BigTable();
        bigTable.setSize(110);
        return bigTable;
    }

    @Bean
    public Color color(){
        Red red = new Red();
        return red;
    }

    @Bean
    public BedRoom bedRoom(){
        BedRoom bedRoom = new BedRoom(bigBed(),bigChair(),bigTable(),color());
        return bedRoom;
    }
}
