import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App2 {
    public static void main(String[] args) {

        try (
            HttpClient httpClient = HttpClient.newBuilder()
                .version(Version.HTTP_1_1)
                .followRedirects(Redirect.NORMAL)
                .build();
        ) {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/miyabilink"))
                .header("Accept","application/vnd.github+json")
                .header("X-GitHub-Api-Version","2022-11-28")
                .GET()
                .build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            int httpStatusCode = httpResponse.statusCode();
            String body = httpResponse.body();
            if (httpStatusCode == 200) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(body);
                String blogSiteUrl = root.get("blog").textValue();
                System.out.println("blogサイト: " + blogSiteUrl);
            } else {
                System.out.println("HTTPステータス:" + httpStatusCode);
                System.out.println("メッセージ:" + body);
            } 
        } catch (Exception e) {
            System.out.println("HTTP通信に失敗しました" + e.getMessage());
            e.printStackTrace();
        }

    }
}
