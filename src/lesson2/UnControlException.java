package lesson2;

public class UnControlException extends RuntimeException {
    String txt;

    public UnControlException(String txt) {
        super();
        this.txt = txt;
    }

    @Override
    public String toString() {
        String str  = "Исключение собственного класса - "+ txt +"\n";
        str+= "НЕКОНТРОЛИРУЕМОЕ\n";
        str+= "****************";
        return str;
    }
}
