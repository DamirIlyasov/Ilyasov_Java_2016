/**
 * Created by damir on 17.11.16.
 */
public class Child {
   static String lastName = Father.lastName;
   static String eyeColor = Mother.eyeColor;

   public static void main(String[] args) {
      System.out.println(lastName+" "+eyeColor);
   }
}
