package TPArchivos;


import java.util.Date;

public class Ventas {
    private final Destino destiny;
    private final int productCode;
    private final int quantity;
    private final int price;
    private final Date dateOfPayment;
    private boolean isActive;

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
