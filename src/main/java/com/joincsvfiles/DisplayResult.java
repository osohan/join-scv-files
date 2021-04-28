package com.joincsvfiles;

import java.util.List;

public abstract class DisplayResult {

    private CommunicationInterface communicationInterface;

    public DisplayResult(CommunicationInterface communicationInterface) {
        this.communicationInterface = communicationInterface;
    }

    public abstract void display(FilterSelectedFieldsResult filterSelectedFieldsResult);

    public CommunicationInterface getCommunicationInterface() {
        return communicationInterface;
    }
}
