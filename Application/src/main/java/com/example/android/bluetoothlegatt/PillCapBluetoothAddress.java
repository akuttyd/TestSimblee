package com.example.android.bluetoothlegatt;

import android.bluetooth.BluetoothDevice;

/**
 * Created by akutty on 24/08/16.
 */
public class PillCapBluetoothAddress {

    private BluetoothDevice bluetoothDevice;
    private boolean connectionStatus;

    public PillCapBluetoothAddress(BluetoothDevice device, boolean status) {
        this.bluetoothDevice = device;
        this.connectionStatus = status;
    }

    public BluetoothDevice getBluetoothDevice() {
        return bluetoothDevice;
    }

    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof PillCapBluetoothAddress)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        PillCapBluetoothAddress c = (PillCapBluetoothAddress) o;

        // Compare the data members and return accordingly
        return c.getBluetoothDevice().getAddress().equalsIgnoreCase(bluetoothDevice.getAddress());
    }
}
