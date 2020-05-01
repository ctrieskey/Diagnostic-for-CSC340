package api;

import java.io.*;
import java.net.*;
import org.json.*;

/**
 * The CarDiagApi class connects to the CarMD server to retrieve a diagnostic on
 * the vehicle given its VIN, mileage, and the error code.
 * Note: Do not call this class directly. Route requests through
 * CarDiagApiTranslator
 * Last Updated: 4/13/2020
 * @author Kevin Wright
 */

public class CarDiagApi implements CarApiInterface {
    private static final String BASEURL = "https://api.carmd.com/v3.0";

    private static final String AUTHORIZATION = "Basic ZGNmMDgwY2QtNTA1NS00NWYyLWEzYTMtOTBiMTRlMTdiNzg4";

    private static final String PARTNERTOKEN = "a860eab57e804808b3f4ce3862359995";

    @Override
    public String loadDiagnostic(String _vin, int _mileage, String _dtCode) {
        // Build the search URL
        String search = "/diag?vin=" + _vin + "&mileage=" + _mileage + "&dtc=" + _dtCode;

        try {
            //Create the URL and connect to the API
            URL url = new URL(this.BASEURL + search);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("authorization", this.AUTHORIZATION);
            con.setRequestProperty("partner-token", this.PARTNERTOKEN);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            //Disconnect from the API
            in.close();
            con.disconnect();
            //Create the output object
            System.out.println("Output: " + content.toString());
            JSONObject obj = new JSONObject(content.toString());
            JSONObject data = obj.getJSONObject("data");
            String urgency = data.getString("urgency_desc");
            String effect = data.getString("effect_on_vehicle");
            String responsible = data.getString("responsible_system");
            String diagnostic = urgency + "\n" + effect + "\n" + responsible;
            return diagnostic;
        } catch(IOException | JSONException exception) {
            return null;
        }
    }
}