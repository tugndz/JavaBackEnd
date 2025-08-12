package Phone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PhoneManager {
    private final List<Phone> phones = new ArrayList<>();

    public void add(Phone p) {
        phones.add(p);
    }

    public List<Phone> list() {
        return new ArrayList<>(phones);
    }

    public Optional<Phone> findById(String id) {
        if (id == null) return Optional.empty();
        return phones.stream().filter(p -> id.equalsIgnoreCase(p.getId())).findFirst();
    }

    public long sumTotalPrice() {
        long sum = 0;
        for (Phone p : phones) sum += p.totalPrice();
        return sum;
    }

    public void promoteAll(double percent) {
        for (Phone p : phones) p.promote(percent);
    }

    public void sortByTotalPriceDesc() {
        phones.sort(Comparator.comparingLong(Phone::totalPrice).reversed());
    }
}
