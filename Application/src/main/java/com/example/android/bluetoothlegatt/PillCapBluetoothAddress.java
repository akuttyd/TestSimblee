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

        if (o == this) return true;
        if (!(o instanceof PillCapBluetoothAddress)) {
            return false;
           }

      PillCapBluetoothAddress user = (PillCapBluetoothAddress) o;

       return user.getBluetoothDevice().getAddress().equals(bluetoothDevice.getAddress());
      }

   //Idea from effective Java : Item 9
   @Override
    public int hashCode() {
       int result = 17;
       result = 31 * result + bluetoothDevice.getAddress().hashCode();
       return result;
        }


}
