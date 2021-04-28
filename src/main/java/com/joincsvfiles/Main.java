package com.joincsvfiles;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CommunicationInterface communicationInterface = new CommunicationInterfaceFactory().getInputData(CommunicationType.CONSOLE_WITH_BASE_DATA);
        InputData inputData = communicationInterface.getData();
        JoinOperation joinOperation = new InnerJoin(inputData.getDataSource1(), inputData.getDataSource2(), inputData.getDataSource1JoinId(), inputData.getDataSource2JoinId());
        List<String[]> result = joinOperation.join(null, null, new DefaultOrderBy(joinOperation.getJoinIdIndexInDataSource2()));

        FilterSelectedFieldsResult filterSelectedFieldsResult = new FilterSelectedFieldsBase().filter(inputData.getSelectFields(), joinOperation.getJoinedFieldNames(), result);

        DisplayResult displayResult = new DisplayResultSimpleImpl(communicationInterface);
        displayResult.display(filterSelectedFieldsResult);
    }

}
