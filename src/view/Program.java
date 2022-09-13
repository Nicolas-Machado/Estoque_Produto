package view;

import model.Product;
import service.ProductController;

import javax.swing.*;

public class Program {

    private static final int OPERATION_ADD_VALUE = 1;
    private static final int OPERATION_REMOVE_VALUE = 2;
    private static final int OPERATION_CHANGE_PRICE = 3;
    private static final int OPERATION_SHOW_VALUE = 4;
    private static final int OPERATION_EXIT = 5;

    public static void main(String[] args) {

        boolean validation = true;

        Product product = new Product();
        JOptionPane.showMessageDialog(null, "Enter product data");

        try {
            String name = JOptionPane.showInputDialog(null, "Product Name: ");
            product.setName(name);

            double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Price: "));
            product.setPrice(price);

            int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity in Stock: "));
            product.setQuantity(quantity);

            ProductController productController = new ProductController();

            while (validation) {

                int operation = Integer.parseInt(JOptionPane.showInputDialog("Choose the operation: \nAdd items in stock: 1 \nRemove items from stock: 2 " +
                        "\nChange product's price: 3 \nShow total: 4 \nExit: 5"));

                switch (operation) {

                    case OPERATION_ADD_VALUE: {
                        int quantityAdded = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert value to add: "));
                        productController.addProducts(product, quantityAdded);
                        break;
                    }

                    case OPERATION_REMOVE_VALUE: {
                        int quantityRemoved = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert value to remove: "));
                        productController.removeProducts(product, quantityRemoved);
                        break;
                    }

                    case OPERATION_CHANGE_PRICE: {
                        double priceChange = Double.parseDouble(JOptionPane.showInputDialog("Insert the product's new price: "));
                        productController.changeProductPrice(product, priceChange);
                        break;
                    }

                    case OPERATION_SHOW_VALUE: {
                        productController.totalValueInStock(product, product.getPrice(), product.getQuantity());
                        JOptionPane.showMessageDialog(null, "Product Name: " + product.getName() + "\n" + "Quantity: " + product.getQuantity() +
                                "\n" + "Price: R$" + product.getPrice() + "\n" + "Total Value: R$" + product.getTotalValue());
                        break;
                    }

                    case OPERATION_EXIT: {
                        JOptionPane.showMessageDialog(null, "See you later :D");
                        validation = false;
                        break;
                    }

                    default:
                        JOptionPane.showMessageDialog(null, "Incorrect Value!! Try again");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Número digitado de maneira incorreta, tente novamente");
        }

    }
}
