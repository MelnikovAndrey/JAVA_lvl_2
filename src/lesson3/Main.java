package lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String str = "Рошкар Бад-Эль-Казар Атаман Преподобная Валькирия Николас " +
                "Гегемон Заргала Трунда Николас Рошкар Венценосная Заргала Преподобная " +
                "Бад-Эль-Казар Валькирия Криск Инитве Венера Бад-Эль-Казар Рошкар";

        String[] strings = str.split(" ");
        ArrayList<String> arrayLists = new ArrayList<>(Arrays.asList(strings));
        arrayLists.add("Ротос");
//
//        uniqueWordsList(arrayLists);
//        System.out.println();
//        countCopies(strings);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Рошкар", "11111","Иванов@");
        phoneBook.addContact("Заргала", "22222","Заргала@");
        phoneBook.addContact("Инитве", "333333","Инитве@");
        phoneBook.addContact("Бад-Эль-Казар", "444444","Бад-Эль-Казар@");
        phoneBook.addContact("Заргала", "555555","Зар-а@");
        phoneBook.addContact("Рошкар", "66666","Рош-р@");
        phoneBook.addContact("Венера", "7777777","Венера@");

        phoneBook.lookingForPhone("Заргала");
        System.out.println();
        phoneBook.lookingForMail("Рошкар");

//        System.out.println(phoneBook);
    }

    private static void uniqueWordsList(ArrayList list){
        Set<String> set = new HashSet<>(list);
        System.out.println("Список слов из которых состоит текст:");
        for (String s: set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void countCopies(String[] strings){
        System.out.println("Подсчет копий в массиве:");
        Map <String, Integer> hm = new HashMap<>();
            for (String string : strings) {
                if (hm.containsKey(string)) {
                    int count = hm.get(string);
                    hm.put(string, ++count);
                } else {
                    hm.put(string, 1);
                }
            }
            Set<String> set = hm.keySet();
                for (String s: set
                     ) {
                    System.out.println(s + ", кол-во копий = "+ hm.get(s));
                }
        }


    }
