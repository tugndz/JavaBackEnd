package Phone;

/** Điện thoại cũ: có phần trăm pin còn lại (0..100) ảnh hưởng tới tổng giá. */
public class OldPhone extends Phone {
    private int batteryPercent; // 0..100

    public OldPhone(String name, long price, int warrantyMonths, String os, String brand, int batteryPercent)
            throws InvalidDataException {
        super(name, price, warrantyMonths, os, brand);
        setBatteryPercent(batteryPercent);
        setId(PhoneId.nextOld());
    }

    public int getBatteryPercent() { return batteryPercent; }

    public void setBatteryPercent(int batteryPercent) throws InvalidDataException {
        require(0 <= batteryPercent && batteryPercent <= 100, "Phần trăm pin phải trong [0, 100].");
        this.batteryPercent = batteryPercent;
    }

    @Override
    public long totalPrice() {
        return Math.round(getPrice() * (batteryPercent / 100.0));
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
        return super.toString() + String.format(" | Pin: %d%% | Tổng: %,d", batteryPercent, totalPrice());
    }
}
