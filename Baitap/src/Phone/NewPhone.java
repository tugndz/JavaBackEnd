package Phone;


public class NewPhone extends Phone {
    private int quantity;

    public NewPhone(String name, long price, int warrantyMonths, String os, String brand, int quantity)
            throws InvalidDataException {
        super(name, price, warrantyMonths, os, brand);
        setQuantity(quantity);
        setId(PhoneId.nextNew());
    }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) throws InvalidDataException {
        require(quantity >= 0, "Số lượng phải >= 0.");
        this.quantity = quantity;
    }

    @Override
    public long totalPrice() {
        return getPrice() * (long) quantity;
    }

    @Override
    public void promote(double percent) {
        if (percent <= 0) return;
        long newPrice = Math.round(getPrice() * (1 - percent / 100.0));
        try {
            setPrice(Math.max(newPrice, 0));
        } catch (InvalidDataException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | SL: %d | Tổng: %,d", quantity, totalPrice());
    }
}
