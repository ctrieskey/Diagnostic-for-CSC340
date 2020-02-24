package api;

import java.io.*;
import java.net.*;
import org.json.*;

/**
 * The CarDiagApi class connects to the CarMD server to retrieve a diagnostic on
 * the vehicle given its VIN, mileage, and the error code.
 * Note: Do not call this class directly. Route requests through
 * CarDiagApiTraslator
 * Last Updated: 2/12/2020
 * @author Kevin Wright
 */

public class CarDiagApi implements CarApiInterface {
    private static final String baseURL = "https://api.carmd.com/v3.0";

    private static final String authorization = "Basic ZGNmMDgwY2QtNTA1NS00NWYyLWEzYTMtOTBiMTRlMTdiNzg4";

    private static final String partnerToken = "a860eab57e804808b3f4ce3862359995";

    public String loadDiagnostic(String _vin, int _mileage, String _dtCode) {
        // Build the search URL
        String search = "diag?vin=" + _vin + "&mileage=" + _mileage + "&dtc=" + _dtCode;
        try {
            URL url = new URL(CarDiagApi.baseURL + search);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            JSONObject obj = new JSONObject(content.toString());
            String problem = obj.getString("problem");
            return problem;
        } catch(Exception ex) {
            return null;
        }
    }

    @Override
    public String vehicleVin(String _vin) {
        // TODO Auto-generated method stub
        return "1GNALDEK9FZ108495";
    }

    @Override
    public int vehicleMileage(int _mileage) {
        // TODO Auto-generated method stub
        return 100000;
    }

    @Override
    public String vehicleDtc(String _dtCode) {
	// TODO Auto-generated method stub
	return "p0420";
    }
}