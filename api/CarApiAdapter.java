package api;

/**
 * Central connector for all CarMD API calls.
 * Route all requests through this class, not CarDiagApi
 * Last Updated: 2/24/2020
 * @author Kevin Wright
 */

public class CarApiAdapter implements CarApiInterface {
    protected static final CarApiInterface CARMD = new CarDiagApi();

    @Override
    public String loadDiagnostic(String _vin, int _mileage, String _dtCode) {
        return this.CARMD.loadDiagnostic(_vin, _mileage, _dtCode);
    }
}