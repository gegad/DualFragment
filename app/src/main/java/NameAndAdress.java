import java.io.Serializable;

public class NameAndAdress implements Serializable {
    String mName;
    String mAddress1;
    String mAddress2;
    String mZipCode;

    public NameAndAdress(String name, String address1, String address2, String zipCode) {
        mName = name;
        mAddress1 = address1;
        mAddress2= address2;
        mZipCode = zipCode;
    }

    public String getName() {
        return mName;
    }

    public String getAddress1() {
        return mAddress1;
    }

    public String getAddress2() {
        return mAddress2;
    }

    public String getZipCode() {
        return mZipCode;
    }
}
