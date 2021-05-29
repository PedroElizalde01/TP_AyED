package TPArchivos;

public class DolarCotization {
    private final int month;
    private final float cotization;

    public DolarCotization(int month, float cotization) {
        this.month = month;
        this.cotization = cotization;
    }

    public int getMonth() {
        return month;
    }

    public float getCotization() {
        return cotization;
    }
}
