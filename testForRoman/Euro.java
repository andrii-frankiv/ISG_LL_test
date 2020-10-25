package testForRoman;

public class Euro extends Convertor {
    private float euro = 33.57384654f;
    @Override
    public float convert(float currency) {
        return currency/=euro;
    }
}
