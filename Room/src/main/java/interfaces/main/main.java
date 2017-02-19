package interfaces.main;

import interfaces.impl.room.BedRoom;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        BedRoom bedRoom =(BedRoom) context.getBean("bedRoom");
        bedRoom.printContent();
//        GuestRoom guestRoom =(GuestRoom) context.getBean("guestRoom");
//        guestRoom.printContent();
    }
}
