package api;

/**
 * This APIConnector interface defines the methods that need to be implemented
 * for any valid translator class
 * Last Updated 2/12/2020
 * @author Kevin Wright
 */
public interface CarApiInterface {
    public String loadDiagnostic(String _vin, int _mileage, String _dtCode);
}