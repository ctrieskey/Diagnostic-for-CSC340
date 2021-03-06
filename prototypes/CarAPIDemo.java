package prototypes;

import java.io.*;
import java.net.*;
import java.util.logging.*;
import org.json.*;

/**
 * This prototype demonstrates a call to the API
 * @author Kevin Wright
 * Updated 5/1/2020
 */
public class CarAPIDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String baseURL = "https://api.carmd.com/v3.0";
        String callAction = "/diag";
        String vin = "1GNALDEK9FZ108495";
        String mileage = "51000";
        String dtc = "p0420";
        String authorization = "Basic ZGNmMDgwY2QtNTA1NS00NWYyLWEzYTMtOTBiMTRlMTdiNzg4";
        String partnerToken = "a860eab57e804808b3f4ce3862359995";

        String urlString = baseURL + callAction + "?vin=" + vin + "&mileage=" + mileage + "&dtc=" + dtc;
        URL url;

        try {
            //Opens a connection given the authorization and partner token headers.
            url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("authorization", authorization);
            conn.setRequestProperty("partner-token", partnerToken);

            //Gets the response code from the server
            int status = conn.getResponseCode();
            System.out.println("Response Code: " + status);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            //Closes and disconnects from the API.
            in.close();
            conn.disconnect();

            //Builds and displays the output from the API request.
            JSONObject obj = new JSONObject(content.toString());
            JSONObject data = obj.getJSONObject("data");
            String urgency = data.getString("urgency_desc");
            String effect = data.getString("effect_on_vehicle");
            String responsible = data.getString("responsible_system");
            System.out.println("Urgency: " + urgency);
            System.out.println("Effect on Vehicle: " + effect);
            System.out.println("Responsible System: " + responsible);
        } catch (Exception ex) {
            Logger.getLogger(CarAPIDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}