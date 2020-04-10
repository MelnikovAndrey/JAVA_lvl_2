package lesson2;

public class Main {
    public static void main(String[] args) {
        String string = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String txt1 = "ControlException: ";
        String txt2 = "UnControlException";
        int a;

        try {
            arrGen(string);
            a = summ(arrGen(string));
            System.out.println(a);
                try {
                    throw new ControlException(txt1);
                } catch (ControlException e) {
                    e.printStackTrace();
                    throw new UnControlException(txt2);
                }
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("Ошибка индекса");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Ошибка преобразования Стринг в Инт");
        }
    }

    public static String[][] arrGen(String string) throws ArrayIndexOutOfBoundsException {
        String[] a = string.split("\n");
        String[][] b = new String[4][4];
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i].split(" ");
            } return b;
    }

    public static int summ(String[][] arr) {
        int result = 0;
            for (String[] strings : arr) {
                for (int j = 0; j < arr.length; j++) {
                    int x = Integer.parseInt(strings[j]);
                    result += x;
                }
            } return result / 2;
    }
}
