package datastore;

/*
This class acts as an interface in which
defines the abstract methods that need to be implemented
throughout the package.
@author Taylor Headen
Lasted updated 5/1/2020
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public interface DataStoreInterface {

    public abstract ArrayList<String> createListing();

    public abstract ArrayList<String> readListing();

    public abstract ArrayList<String> updateListing();

    public abstract void deleteListing(String _vin);

}
