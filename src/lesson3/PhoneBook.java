package lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PhoneBook {

    HashMap<String, List<Person>> hm;

    public PhoneBook() {
        this.hm = new HashMap<>();
    }

    public void addContact(String surname, String phone, String mail) {
        HashSet<String> ph = new HashSet<>();
//        HashSet<String> ph = hm.getOrDefault(surname, new HashSet<List<Person>>()) ;
        ph.add(phone);
        HashSet<String> ml = new HashSet<>();
        ml.add(mail);
        List<Person> people = new ArrayList<>();
        people.add(new Person(ph, ml));
        hm.put(surname, people);
    }

    public void lookingForPhone(String surname) {
        List<Person> person = hm.get(surname);
        System.out.println("Фамилия " + surname + " номера - " + person);
    }

    public void lookingForMail(String surname) {
        List<Person> person = hm.get(surname);
        System.out.println("Фамилия " + surname + " почта - " + person);
    }
}
