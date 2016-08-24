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
}
