package Api;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;


public class GeminiTextGeneratorImpl implements GeminiTextGenerator {

    private final Client client;
    private static final String MODEL_ID = "gemini-2.5-flash";

    public GeminiTextGeneratorImpl() {
        // recuerda utilizar GOOGLE_API_KEY.
        this.client = new Client();
    }

    @Override
    public String generateText(String prompt) throws Exception {
        if (prompt == null || prompt.trim().isEmpty()) {
            return "Error: Prompt cannot be empty.";
        }

        try {
            GenerateContentConfig config = GenerateContentConfig.builder()
                    .temperature(0.7f)
                    .build();

            GenerateContentResponse response = client.models.generateContent(
                    MODEL_ID,
                    prompt,
                    config
            );

            // Extract the generated text
            return response.text();

        } catch (Exception e) {
            System.err.println("Gemini API call failed: " + e.getMessage());
            throw new Exception("Failed to generate content from Gemini API.", e);
        }
    }
}