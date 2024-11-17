import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class WebsiteStatus {
    private final int OK_CODE = 200;
    private final int FORBIDDEN_CODE = 403;
    private final int ERROR_CODE = 500;
    private final int TIMEOUT_IN_SECONDS = 10;

    private URI uri;

    public WebsiteStatus(URI uri) {
        this.uri = uri;
        formatURI();
    }

    public void getStatusCode() {
        this.getStatusCodeAsync().thenAccept(this::printWebsiteChecking);
    }

    private void printWebsiteChecking(Integer statusCode) {
        System.out.println("CHECKING ["+ this.uri + "]:");

        switch(statusCode) {
            case OK_CODE, FORBIDDEN_CODE:
                System.out.println(" - The website is working (" + statusCode + ").");
                break;
            case ERROR_CODE:
                System.out.println(" - The website could not be reached.");
                break;
            default:
                System.out.println(" - The website is not working (" + statusCode + "). (maybe you need to add www?)");
                break;
        }
    }

    private CompletableFuture<Integer> getStatusCodeAsync() {
        try(HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .timeout(Duration.ofSeconds(TIMEOUT_IN_SECONDS))
                    .build();

            CompletableFuture<HttpResponse<String>> futureResponse = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
            return futureResponse.thenApply(HttpResponse::statusCode)
                    .exceptionallyAsync(ex -> ERROR_CODE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(ERROR_CODE);
    }

    private void formatURI() {
        if(!String.valueOf(this.uri).contains("https://") || !String.valueOf(this.uri).contains("http://")) {
            this.uri = URI.create("https://" + this.uri);
        }
    }
}
