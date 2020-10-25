package testForRoman;

public class Dollars extends Convertor{
    private double dollar = 28.337456321;
    @Override
    public float convert(float currency) {
        return  currency/=dollar;
    }
}
