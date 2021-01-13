package put.io.patterns.implement;
import java.util.ArrayList;
import java.util.List;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class SystemMonitor {
    private List<SystemStateObserver> observers = new ArrayList<SystemStateObserver>();

    private SystemInfo si;

    private HardwareAbstractionLayer hal;

    private OperatingSystem os;

    private SystemState lastSystemState = null;

    public SystemMonitor(){
        si = new SystemInfo();
        hal = si.getHardware();
        os = si.getOperatingSystem();

    }

    public void addSystemStateObserver(SystemStateObserver observer){ observers.add(observer); }

    public void removeSystemStateObserver(SystemStateObserver observer){ observers.remove(observer); }

    public void notifyObservers(){
        for(SystemStateObserver observer : this.observers){
            observer.update(this.lastSystemState);
        }
    }

    public void probe(){

        // Get current state of the system resources
        double cpuLoad = hal.getProcessor().getSystemCpuLoad()*100;
        double cpuTemp = hal.getSensors().getCpuTemperature();
        double memory = hal.getMemory().getAvailable() / 1000000;
        int usbDevices = hal.getUsbDevices(false).length;

        lastSystemState = new SystemState(cpuLoad, cpuTemp, memory, usbDevices);

        notifyObservers();

    }

    public SystemState getLastSystemState() {
        return lastSystemState;
    }
}
