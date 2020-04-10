package lesson2;

public class ControlException extends Exception {
    String txt;

    public ControlException(String txt) {
        super();
        this.txt = txt;
    }

    @Override
    public String toString() {
        String str  = "Исключение собственного класса - " + txt + "\n";
        str+= "Контролируемое\n";
        str+= "****************";
        return str;
    }
}
