package com.joincsvfiles;

public class CommunicationInterfaceFactory {

    public CommunicationInterface getInputData(CommunicationType communicationType) {
        switch (communicationType) {
            case CONSOLE_WITH_BASE_DATA: return new CommunicationInterfaceFromCliWithBaseData();
        }
        return null;
    }

}
