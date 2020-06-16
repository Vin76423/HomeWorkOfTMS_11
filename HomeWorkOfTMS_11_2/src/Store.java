import java.util.ArrayList;

public class Store {
    private ArrayList<Product> products = new ArrayList<>();

    public Store() { }



    public ArrayList<Product> getProducts() {
        ArrayList<Product> newList = new ArrayList<>(products);
        return newList;
    }

    public boolean setProduct(Product product) {
        for (Product pr : products) {
            if (pr.getId() == product.getId()) {
                System.out.println("Такой продукт в магазине уже есть!");
                return false;
            }
        }
        products.add(product);
        return true;
    }

    public boolean removeProduct(int id) {
        Product temp = null;
        for (Product pr : products) {
            if (pr.getId() == id) {
                temp = pr;
                break;
            }
        }
        if (temp == null) {
            System.out.println("Такого продукта нет в асортименте!");
            return false;
        }
        products.remove(temp);
        return true;
    }

    public boolean editProducts(Product product) {
        int index = -1;
        for (Product pr : products) {
            index++;
            if (pr.getId() == product.getId()) {
                System.out.println("Продукт " + pr.getName() + " был заменен на " + product.getName());
                products.set(index,product);
                return true;
            }
        }
        System.out.println("Такого продукта у нас нет.");
        return false;
    }
}
