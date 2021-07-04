package TPArchivos;


import java.util.Date;

public class Ventas {
    private final Destino destiny;
    private final int productCode; // 4 bytes
    private final int quantity; // 4
    private final int price; // 4 bytes
    private final Date dateOfPayment;
    private boolean isActive; // 1 bytes

    public Ventas(Destino destinyCode, int productCode, int quantity, int price, Date dateOfPayment, boolean isActive) {
        this.destiny = destinyCode;
        this.productCode = productCode;
        this.quantity = quantity;
        this.price = price;
        this.dateOfPayment = dateOfPayment;
        this.isActive = isActive;
    }

    public Destino getDestiny() {
        return destiny;
    }

    public int getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
