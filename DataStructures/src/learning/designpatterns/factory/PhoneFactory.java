package learning.designpatterns.factory;

public class PhoneFactory {

    public static Phone getPhone(String s) {
        switch (s) {
            case "apple" : return new IPhone();
            case "google" : return  new AndroidPhone();
            case "microsoft" : return new WindowsPhone();
        }
        return null;
    }
}
