package designpatterns.abstractfactory;

public class HP implements Device {
    @Override
    public void getDeviceDetails() {
        System.out.println("HP");
    }
}
