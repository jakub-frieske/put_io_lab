package put.io.patterns.implement;


public class USBDeviceObserver implements SystemStateObserver {
    int last_usb=0;
    boolean last_usb_init=false;
    @Override
    public void update(SystemState lastSystemState) {
        int current_usb=lastSystemState.getUsbDevices();
        if(!last_usb_init){
            last_usb=current_usb;
            last_usb_init=true;
        }
        else{
            if(last_usb!=current_usb){
                System.out.println(String.format("USBDevice changed: from %d to %d", last_usb,current_usb));
                last_usb=current_usb;
            }
        }


    }
}