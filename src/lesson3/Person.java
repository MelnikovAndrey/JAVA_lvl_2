package lesson3;

import java.util.HashSet;

public class Person {

    private HashSet<String> phone;
    private HashSet<String> mail;


    public Person(HashSet<String> phone, HashSet<String> mail) {
        this.phone = phone;
        this.mail = mail;
    }

    public HashSet<String> getPhone() {
        return phone;
    }

    public HashSet<String> getMail() {
        return mail;
    }

    @Override
    public String toString() {
         return "Фамилия " +  + " номера " + phone + " почта " + mail;
    }
}
