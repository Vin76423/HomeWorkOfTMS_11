import java.util.Comparator;

public class ComparatorStore implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Product pr1 = (Product) o1;
        Product pr2 = (Product) o2;

        if (pr1.price > pr2.price) return 1;
        else if (pr1.price == pr2.price) return 0;
        else return -1;
    }
}
