package api;

import java.io.*;
import java.net.*;
import org.json.*;

/**
 * The CarDiagApi class connects to the CarMD server to retrieve a diagnostic on
 * the vehicle given its VIN, mileage, and the error code.
 * Note: Do not call this class directly. Route requests through
 * CarDiagApiTranslator
 * Last Updated: 2/30/2020
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
            URL url = new URL(CarDiagApi.BASEURL + search);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("authorization", AUTHORIZATION);
            con.setRequestProperty("partner-token", PARTNERTOKEN);
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
            JSONObject obj = new JSONObject(content.toString());
            String problem = obj.getString("problem");
            return problem;
        } catch(IOException | JSONException exception) {
            return null;
        }
    }
}