package rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class WarehouseServer {
    public static void main(String[] args) {
        try {
            Warehouse warehouse = new Warehouse();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("warehouse", warehouse);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ready for clients.");
    }
}
