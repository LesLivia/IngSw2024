package rmi.server;

import rmi.shared.WarehouseI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Warehouse extends UnicastRemoteObject implements WarehouseI {
    private Map<String, Double> prices;


    public Warehouse() throws RemoteException {
        this.prices = new HashMap<>();
        this.prices.put("Blackwell Toaster", 24.95);
        this.prices.put("ZapXpress Microwave Oven", 49.95);
    }

    @Override
    public double getPrice(String s) {
        Double price = this.prices.get(s);
        return price == null ? 0 : price;
    }

}
