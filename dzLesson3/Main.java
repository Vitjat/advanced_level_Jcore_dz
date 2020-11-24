package dzLesson3;

import javax.naming.PartialResultException;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String [] arr = {
                "арбуз", "велосипед", "телефон", "компьютер", "велосипед",
                "мопед", "компьютер", "сплитер", "роутер", "стол",
                "роутер", "телефон", "телефон", "велосипед", "гитара",
                "телефон", "стол", "стул", "компьютер", "роутер"
        };

        HashMap<String, Integer> map = new HashMap<>();

        for (String x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        System.out.println(map);


        TelephoneDirectory catalog = new TelephoneDirectory();
        catalog.addContact("Иванов", "89995553355, 43434343");
        catalog.addContact("Синицын", "555666777888");
        catalog.addContact("Петров", "89233332245");
        catalog.addContact("Птицын", "2466754787");


        System.out.println("Телефон" + catalog.get("Иванов"));
        System.out.println("Телефон" + catalog.get("Синицын"));
        System.out.println("Телефон" + catalog.get("Петров"));

    }
}
