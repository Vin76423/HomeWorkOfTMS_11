import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> str1 = new ArrayList<>();
        str1.add("Витя");
        str1.add("Саша");
        str1.add("Петя");
        ArrayList<String> str2 = new ArrayList<>();
        str2.add("Миша");
        str2.add("Гриша");

        str1.addAll(2, str2);
        System.out.println(Arrays.toString(str1.toArray()));

        System.out.println(str1.contains("Гриша") ? "Да, есть такое имя" : "Нет , нету");
        str1.remove("Петя");
        System.out.println(Arrays.toString(str1.toArray()));
        str1.remove(2);
        System.out.println(Arrays.toString(str1.toArray()));



        ArrayList<String> str3 = new ArrayList<>();
        str3.add("Света");
        str3.add("Марина");
        str3.add("Полина");
        str3.add("Катя");
        str1.addAll(str3);
        System.out.println("получился список - " + Arrays.toString(str1.toArray()) + " , размером - " + str1.size());
    }
}
