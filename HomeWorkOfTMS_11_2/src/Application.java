import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private Store store = new Store();
    private ComparatorStore comparator = new ComparatorStore();

    public void run(){
        getOperation();
    }

    private void showMenu() {
        System.out.println("1 - Вывод всех товаров");
        System.out.println("2 - Добавление товара");
        System.out.println("3 - Удаление товара");
        System.out.println("4 - Редактирование товара");
        System.out.println("0 - Выход");
    }

    private void showInputMenu() {
        System.out.println("1 - По цене, по возрастанию");
        System.out.println("2 - По цене, по убыванию");
        System.out.println("3 - По дате привоза, от более старых товаров к новым (порядок по умолчанию)");
        System.out.println("4 - По дате привоза, от более новых товаров к старым");
        System.out.println("0 - Вернуться обратно");
    }

    private void getOperation() {
        System.out.println("Выберите действие:");
        showMenu();
        System.out.println();
        int choice = inputNumber(0 ,4, "Введите число:");
        switch (choice) {
            case 0 : return;
            case 1 :
                getInputOperation();
                break;
            case 2 :
                getSetProductOperation();
                break;
            case 3 :
                getRemoveProductOperation();
                break;
            case 4 :
                getEditProductOperation();
                break;
        }
        getOperation();
    }

    private void getInputOperation() {
        if (checkStoreIsEmpty()) return;

        System.out.println("Выберите вид сортировки:");
        showInputMenu();
        System.out.println();
        ArrayList<Product> list = store.getProducts();
        ArrayList<Product> temp = new ArrayList<>();
        int choice = inputNumber(0 ,4, "Введите число:");

        switch (choice) {
            case 0 : return;
            case 1 :
                list.sort(comparator);
                break;
            case 2 :
                list.sort(comparator.reversed());
                break;
            case 3 :
                break;
            case 4 :
                for (int i = list.size() - 1; i >= 0; i--) {
                    temp.add(list.get(i));
                }
                list = temp;
                break;
        }

        showList(list);
    }

    private void getSetProductOperation() {
        int tempId = inputNumber(10000 ,99999, "Введите id товара (в формате ХХХХХ):");
        String tempName = inputString("Введите название товара:");
        int tempPrice = inputNumber(100 ,999, "Введите цену товара (в формате ХХХ):");

        Product product = new Product(tempId, tempName, tempPrice);
        if (!store.setProduct(product)) {
            System.out.println("Попробуйте ещё раз...");
            getSetProductOperation();
        }
    }

    private void getRemoveProductOperation(){
        if (checkStoreIsEmpty()) return;

        int removedProduct = inputNumber(10000 ,99999, "Введите id товара (в формате ХХХХХ)," +
                " который хотите удалить:");

        if (!store.removeProduct(removedProduct)) {
            System.out.println("Попробуйте ещё раз...");
            getRemoveProductOperation();
        }
    }

    private void getEditProductOperation() {
        if (checkStoreIsEmpty()) return;

        int tempId = inputNumber(10000 ,99999, "Введите id товара (в формате ХХХХХ):");
        String tempName = inputString("Введите название товара:");
        int tempPrice = inputNumber(100 ,999, "Введите цену товара (в формате ХХХ):");

        Product product = new Product(tempId, tempName, tempPrice);
        if (!store.editProducts(product)) {
            System.out.println("Попробуйте ещё раз...");
            getEditProductOperation();
        }
    }

    private int inputNumber (int minBorder, int maxBorder, String massage) {
        int input;
        System.out.println(massage);

        while ( true ) {
            Scanner scanner = new Scanner(System.in);

            if ( !scanner.hasNextInt() ) {
                System.out.println("Значение не корректно, попробуйте еще раз:");
                continue;
            }

            input = scanner.nextInt();
            if ( input < minBorder || input > maxBorder ) {
                System.out.println("Значение не корректно, попробуйте еще раз:");
                continue;
            }

            break;
        }
        return input;
    }

    private String inputString (String massage) {
        System.out.println(massage);
        Scanner scanner = new Scanner(System.in);

        return scanner.next();
    }

    private boolean checkStoreIsEmpty() {
        boolean result = store.getProducts().isEmpty();
        if (result) System.out.println("В магазине пока нет никаких продуктов");
        return result;
    }

    private static void showList(ArrayList<Product> list) {
        for (Product product : list) {
            System.out.print("Название - " + product.getName() + "; ");
            System.out.print("id - " + product.getId() + "; ");
            System.out.print("Цена - " + product.getPrice() + ".");
            System.out.println();
        }
        System.out.println("\n");
    }

}
