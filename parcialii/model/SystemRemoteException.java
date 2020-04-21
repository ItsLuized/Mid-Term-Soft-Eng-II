package parcialii.model;

import java.rmi.RemoteException;

public class SystemRemoteException extends RemoteException {
    String str;

    public SystemRemoteException(String s) {
        this.str = s;
    }

    @Override
    public String toString() {
        return "SystemRemoteException{" +
                "str='" + str + '\'' +
                '}';
    }
}
