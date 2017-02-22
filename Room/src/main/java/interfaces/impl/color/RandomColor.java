package interfaces.impl.color;

import interfaces.Color;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class RandomColor implements FactoryBean<interfaces.Color>, Color {

    private String colorName;

    public RandomColor(){
    }
    public interfaces.Color getObject() throws Exception {
        Random random = new Random();
        int numberOfColor = random.nextInt(3);
        switch (numberOfColor){
            case 0: {
                colorName = "красный";
                break;
            }
            case 1: {
                colorName = "зелёный";
                break;
            }
            case 2: {
                colorName = "жёлтый";
                break;
            }
            case 3: {
                colorName = "голубой";
                break;
            }
        }
        RandomColor color = new RandomColor();
        color.setColorName(colorName);
        return color;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Class<?> getObjectType() {
        return RandomColor.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public String getName() {
        return colorName;
    }
}
