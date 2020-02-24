package api;

import java.io.*;
import java.net.*;

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

	@Override
	public String vehicleVin(String _vin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int vehicleMileage(int _mileage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String vehicleDtc(String _dtCode) {
		// TODO Auto-generated method stub
		return null;
	}
}