package rmi.client;

import rmi.shared.WarehouseI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class WarehouseClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry();

        String[] e = registry.list();
        for (int i = 0; i < e.length; i++)
            System.out.println(e[i]);

        String remoteObjectName = "warehouse";
        WarehouseI warehouse = (WarehouseI) registry.lookup(remoteObjectName);
        System.out.println(warehouse.getPrice("Blackwell Toaster"));
    }
}
