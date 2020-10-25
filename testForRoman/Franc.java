package testForRoman;

public class Franc extends Convertor {
    private Double franc = 31.31907249;
    @Override
    public float convert(float currency) {
        return currency/=franc;
    }
}
