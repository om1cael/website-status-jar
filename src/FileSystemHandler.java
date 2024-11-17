import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileSystemHandler {
    private Path path = Path.of("websites.txt");

    private void createWebsitesFile() {
        if(!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Error while trying to create file: " + e.getMessage());
            }
        }
    }

    public List<String> readWebsites() {
        createWebsitesFile();

        List<String> websites = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while((line = reader.readLine()) != null) {
                websites.add(line);
            }
        } catch (IOException e) {
            System.out.println("Could not read the file.");
        }

        return websites;
    }
}
