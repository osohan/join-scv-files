package com.joincsvfiles;

import java.util.Arrays;

public class DisplayResultSimpleImpl extends DisplayResult {

    public DisplayResultSimpleImpl(CommunicationInterface communicationInterface) {
        super(communicationInterface);
    }

    public void display(FilterSelectedFieldsResult filterSelectedFieldsResult) {
        this.getCommunicationInterface().sendMsg(Arrays.toString(filterSelectedFieldsResult.getHeader()));
        for (String[] dataRow : filterSelectedFieldsResult.getResult()) {
            this.getCommunicationInterface().sendMsg(Arrays.toString(dataRow));
        }
    }

}
