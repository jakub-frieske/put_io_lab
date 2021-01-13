package put.io.patterns.implement;

public class MonitorRunner {

    public static void main(String args[]){
        SystemMonitor monitor = new SystemMonitor();

        SystemStateObserver infoObserver = new SystemInfoObserver();
        SystemStateObserver garbageObserver = new SystemGarbageCollectorObserver();
        SystemStateObserver coolerObserver = new SystemCoolerObserver();
        SystemStateObserver usbObserver = new USBDeviceObserver();
        monitor.addSystemStateObserver(infoObserver);
        monitor.addSystemStateObserver(coolerObserver);
        monitor.addSystemStateObserver(garbageObserver);
        monitor.addSystemStateObserver(usbObserver);

        while (true) {

            monitor.probe();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
