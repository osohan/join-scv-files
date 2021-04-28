package com.joincsvfiles;

public class CommunicationInterfaceFromCliWithBaseData implements CommunicationInterface {

    public InputData getData() {
        InputData inputData = new InputData();
        inputData.setDataSource1(new CsvDataSourceBase("C:\\Users\\osokhan\\IdeaProjects\\join-csv-files\\src\\main\\resources\\Test Task.csv"));
        inputData.setDataSource2(new CsvDataSourceBase("C:\\Users\\osokhan\\IdeaProjects\\join-csv-files\\src\\main\\resources\\Test_Task.csv"));
        inputData.setOperation(Operation.INNER_JOIN);
        inputData.setDataSource1JoinId("department_id");
        inputData.setDataSource2JoinId("id");
        inputData.setSelectFields(new SelectField[]{
                new SelectField("datasource1", "name", null),
                new SelectField("datasource1", "surname", null),
                new SelectField("datasource2", "name", "department_name"),
        });
        return inputData;
    }

    public void sendMsg(String msg) {
        System.out.println(msg);
    }

}
