package TPArchivos;

public class Destino {
    private final String destinyCode;
    private final String description;

    public Destino(String destinyCode) {
        this.destinyCode = destinyCode;
        this.description = "";
    }

    public String getDestinyCode() {
        return destinyCode;
    }

    public String getDescription() {
        return description;
    }
}
