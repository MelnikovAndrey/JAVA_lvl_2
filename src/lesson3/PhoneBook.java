package lesson3;


import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    Person person;
    HashMap<String, Person> hm;

    public PhoneBook() {
        this.hm = new HashMap<>();
    }


    public void addContact(String surname, String phone, String mail){
//        ArrayList<String> list = new ArrayList<>();
//        list.add(surname);
        hm.put(surname, new Person(phone, mail));
    }

    public void lookingForPhone(String surname){

        System.out.println("Фамилия" + hm.get(surname) + " есть номера - "+ person.getPhone());
    }
    public void lookingForMail(String surname){
        System.out.println("Фамилия" + hm.get(surname) + " есть номера - "+ person.getMail());
    }

}


//          2. Написать простой класс PhoneBook(внутри использовать HashMap):
//        - В качестве ключа использовать фамилию
//        - В каждой записи всего два поля: phone, e-mail
//        - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
//        и отдельный метод для поиска e-mail по фамилии. Следует учесть, что под одной фамилией может быть несколько
//                записей. Итого должно получиться 3 класса Main, PhoneBook, Person.