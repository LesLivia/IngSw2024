package rmi.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WarehouseI extends Remote {
    double getPrice(String s) throws RemoteException;
}
