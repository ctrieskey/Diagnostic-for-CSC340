package api;

/**
 * Last Updated: 2/19/2020
 * @author Kevin Wright
 */

public class CarApiAdapter implements CarApiInterface {
    protected static final CarApiInterface carMD = new CarDiagApi();

    @Override
    public String loadDiagnostic(String _vin, int _mileage, String _dtCode) {
        return CarApiAdapter.carMD.loadDiagnostic(_vin, _mileage, _dtCode);
    }
}