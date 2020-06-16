import java.util.*;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        store.setProduct(new Product(10125, "potato", 25));
        store.setProduct(new Product(12345, "cucumber", 13));
        store.setProduct(new Product(10345, "carrot", 18));

        ArrayList<Product> list1 = store.getProducts();
        ComparatorStore comparator = new  ComparatorStore();
        list1.sort(comparator);
        showList(list1);

        store.removeProduct(10125);

        ArrayList<Product> list2 = store.getProducts();
        ArrayList<Product> temp = new ArrayList<>();
        for (int i = list2.size() - 1; i >= 0; i--) {
            temp.add(list2.get(i));
        }
        list2 = temp;
        showList(list2);

        Product carrot = new Product(10345, "carrot", 45);
        store.editProducts(carrot);
        ArrayList<Product> list3 = store.getProducts();
        showList(list3);
     }





     public static void showList(ArrayList<Product> list) {
         for (Product product : list) {
             System.out.print(product.getName() + " ");
             System.out.print(product.getId() + " ");
             System.out.print(product.getPrice());
             System.out.println();
         }
         System.out.println("\n");
     }
}
