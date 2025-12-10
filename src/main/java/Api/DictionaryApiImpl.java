package Api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


public class DictionaryApiImpl implements DictionaryApi {

    private static final String BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/";
    private final HttpClient httpClient;
    private final Gson gson;

    public DictionaryApiImpl() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    @Override
    public String getPrimeraDefinicion(String word) throws Exception {
        if (word == null || word.trim().isEmpty()) {
            return null;
        }

        String url = BASE_URL + word.trim().toLowerCase();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("API call failed with status code: " + response.statusCode());
        }

        String jsonBody = response.body();

        Type listType = new TypeToken<List<DictionaryEntry>>() {}.getType();
        List<DictionaryEntry> entries = gson.fromJson(jsonBody, listType);

        if (entries != null && !entries.isEmpty()) {
            DictionaryEntry firstEntry = entries.get(0);

            if (firstEntry.getMeanings() != null && !firstEntry.getMeanings().isEmpty()) {

                Meaning firstMeaning = firstEntry.getMeanings().get(0);
                if (firstMeaning.getDefinitions() != null && !firstMeaning.getDefinitions().isEmpty()) {
                    return firstMeaning.getDefinitions().get(0).getDefinition();
                }
            }
        }

        return null;
    }
}