package testForRoman;

public class Main {
    public static void main(String[] args) {
        Float amount = Float.valueOf(1000);
        Convertor dollars = new Dollars();
        Convertor euro =  new Euro();
        Convertor franc = new Franc();
        Convertor zloty = new Zloty();
        System.out.printf(amount + "UAH converted into dollars: %.4f %n", dollars.convert(amount));
        System.out.printf(amount + "UAH converted into euro: %.4f %n", euro.convert(amount));
        System.out.printf(amount + "UAH converted into franc: %.4f %n", franc.convert(amount));
        System.out.printf(amount + "UAH converted into zloty: %.4f %n", zloty.convert(amount));
    }
}
