import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import org.json.JSONObject;
import java.io.*;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import project.connectionpro;

public class stripewebhook {
    public static void main(String[] args) throws IOException {
        int port = 8081; // Webhook listens on port 8081
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/webhook", new StripeWebhookHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Stripe Webhook server started on port " + port);
    }
}

class StripeWebhookHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            InputStream inputStream = exchange.getRequestBody();
            String requestBody = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().reduce("", (acc, line) -> acc + line);
            inputStream.close();

            try {
                JSONObject json = new JSONObject(requestBody);
                String eventType = json.getString("type");

                if ("checkout.session.completed".equals(eventType)) {
                    JSONObject session = json.getJSONObject("data").getJSONObject("object");
                    String meterNumber = session.getString("client_reference_id");

                    System.out.println("Payment received for Meter Number: " + meterNumber);
                    
                    updateBillStatus(meterNumber);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        exchange.sendResponseHeaders(200, 0);
        OutputStream os = exchange.getResponseBody();
        os.close();
    }

    private void updateBillStatus(String meterNumber) {
        try {
            Connection con = connectionpro.getconn();
            String query = "UPDATE bills SET Payment_status = 'Paid' WHERE `meter number` = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, meterNumber);
            pst.executeUpdate();
            System.out.println("Updated bill status for meter number: " + meterNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
