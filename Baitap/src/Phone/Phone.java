package Phone;

public abstract class Phone implements Promotion {
    private String id;
    private String name;
    private long price;
    private int warrantyMonths;
    private String os;
    private String brand;


    protected Phone() {}

    protected Phone(String name, long price, int warrantyMonths, String os, String brand) throws InvalidDataException {
        setName(name);
        setPrice(price);
        setWarrantyMonths(warrantyMonths);
        setOs(os);
        setBrand(brand);
    }


    protected static void require(boolean cond, String message) throws InvalidDataException {
        if (!cond) throw new InvalidDataException(message);
    }



    public abstract long totalPrice();


    public String getId() { return id; }
    protected void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) throws InvalidDataException {
        require(name != null && !name.trim().isEmpty(), "Tên điện thoại không được để trống.");
        this.name = name.trim();
    }

    public long getPrice() { return price; }
    public void setPrice(long price) throws InvalidDataException {
        require(price >= 0, "Giá phải >= 0.");
        this.price = price;
    }

    public int getWarrantyMonths() { return warrantyMonths; }
    public void setWarrantyMonths(int warrantyMonths) throws InvalidDataException {
        require(warrantyMonths >= 0, "Số tháng bảo hành phải >= 0.");
        this.warrantyMonths = warrantyMonths;
    }

    public String getOs() { return os; }
    public void setOs(String os) throws InvalidDataException {
        require(os != null && !os.trim().isEmpty(), "Hệ điều hành không được trống.");
        this.os = os.trim();
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) throws InvalidDataException {
        require(brand != null && !brand.trim().isEmpty(), "Hãng không được trống.");
        this.brand = brand.trim();
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | %s | OS: %s | %d tháng | Giá: %,d",
                id, brand, name, os, warrantyMonths, price);
    }
}
