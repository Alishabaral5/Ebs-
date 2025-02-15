import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class EmailValidator {
    private static final String API_KEY = "7450041aca86afc2b36c7370b9b537ab2782b610";
    private static final String API_URL = "https://api.hunter.io/v2/email-verifier?email=";
     public static boolean isValidGmailFormat(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean verifyEmail(String email) {
        try {
             // First, check if the email format is correct (only Gmail for this case)
            if (!isValidGmailFormat(email)) {
                System.out.println("Invalid Gmail format.");
                return false;
            }

            // Build the URL with the email address and your API key
            String urlString = API_URL + email + "&api_key=" + API_KEY;
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the JSON response
            String responseString = response.toString();
            JSONObject responseObject = new JSONObject(responseString);
            JSONObject data = responseObject.getJSONObject("data");

            // Check the "status" field
            String status = data.getString("status");

            // If the status is "valid", return true
             if ("valid".equals(status)) {
                System.out.println(email + " is a valid and existing email.");
                return true;
            } else {
                System.out.println(email + " is not a valid or existing email.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String testEmail = "lamichhaneanuja24@gmail.com"; // Replace with the email you want to verify
        if (verifyEmail(testEmail)) {
            System.out.println(testEmail + " is a valid email.");
        } else {
            System.out.println(testEmail + " is not valid.");
        }
    }
}
