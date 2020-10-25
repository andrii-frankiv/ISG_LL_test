package testForRoman;

public class Zloty extends Convertor {
    private Float zloty = 7.35507412f;
    @Override
    public float convert(float currency) {
        return currency/=zloty;
    }
}
