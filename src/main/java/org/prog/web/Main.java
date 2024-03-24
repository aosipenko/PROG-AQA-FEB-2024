import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Desktop.getDesktop().browse(new URI("https://rozetka.com.ua/search/?text=iPhone%2015"));
        } catch (IOException | URISyntaxException e) {
            System.err.println("Unable to open the web browser.");
            e.printStackTrace();
        }

        System.out.println("Enter the product name: Мобильный телефон Apple iPhone 15 Pro Max 256GB Black Titanium (MU773RX/A)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("Мобильный телефон Apple iPhone 15 Pro Max 256GB Black Titanium (MU773RX/A)")) {
            System.out.println("The product name is: " + input);
        } else {
            System.out.println("The entered product name does not match the requested one.");
        }
        scanner.close();
    }
}