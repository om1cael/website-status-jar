import java.net.URI;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getChoice();
    }

    private static void getChoice() {
        int choice = 0;

        try(Scanner scanner = new Scanner(System.in)) {
            while(true) {
                System.out.println("1. Check one website");
                System.out.println("2. Check multiple websites (put URLs on .txt)");
                System.out.println("3. Quit");

                System.out.print("Your choice: ");
                choice = scanner.nextInt();

                if(choice == 1) {
                    checkSingleWebsite(scanner);
                } else if(choice == 2) {
                    checkMultipleWebsites();
                } else {
                    System.out.println("Exiting...");
                    break;
                }
            }
        }
    }

    private static void checkSingleWebsite(Scanner scanner) {
        System.out.print("Website: ");
        String website = scanner.next();

        WebsiteStatus websiteStatus = new WebsiteStatus(URI.create(website));
        websiteStatus.getStatusCode();
    }

    private static void checkMultipleWebsites() {
        FileSystemHandler fileSystemHandler = new FileSystemHandler();
        List<String> websites = fileSystemHandler.readWebsites();

        if(websites.isEmpty()) {
            System.out.println("No websites to read!");
            return;
        }

        System.out.println("Reading websites from .txt");
        for(String website : websites) {
            WebsiteStatus websiteStatus = new WebsiteStatus(URI.create(website));
            websiteStatus.getStatusCode();
        }
    }
}