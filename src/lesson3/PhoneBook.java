package lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBook {

    private final HashMap<String, List<Person>> hm;

    public PhoneBook() {
        this.hm = new HashMap<>();
    }

    public void addContact(String surname, String phone, String mail) {
        if(hm.containsKey(surname)) {
            List<Person> people = hm.get(surname);
            people.add(new Person(phone, mail));
            } else{
            List<Person> people = new ArrayList<>();
            people.add(new Person(phone, mail));
            hm.put(surname, people);
        }
    }

    public void lookingForPhone(String surname) {
//        if(!hm.containsKey(surname)) return null;
        List<Person> person = hm.get(surname);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < person.size(); i++) {
            result.add(person.get(i).phone);
        }
//        } return result;
        System.out.println("Фамилия " + surname + " телефоны - " + result);
    }

    public void  lookingForMail(String surname) {
//        if(!hm.containsKey(surname)) return null;
        List<Person> person = hm.get(surname);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < person.size(); i++) {
            result.add(person.get(i).mail);
        }
//        } return result;
        System.out.println("Фамилия " + surname + " почта - " + result);
    }
//    Какой-то сложный вариант решения метода!!!

    public ArrayList<String> getMails(String name) {
        if (!hm.containsKey(name)) return null;

        return hm.get(name).stream().map(person -> person.mail)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
