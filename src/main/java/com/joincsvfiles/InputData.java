package com.joincsvfiles;

public class InputData {
    private DataSource dataSource1;
    private DataSource dataSource2;
    private Operation operation;
    private String dataSource1JoinId;
    private String dataSource2JoinId;
    private SelectField[] selectFields;

    public SelectField[] getSelectFields() {
        return selectFields;
    }

    public void setSelectFields(SelectField[] selectFields) {
        this.selectFields = selectFields;
    }

    public DataSource getDataSource1() {
        return dataSource1;
    }

    public void setDataSource1(DataSource dataSource1) {
        this.dataSource1 = dataSource1;
    }

    public DataSource getDataSource2() {
        return dataSource2;
    }

    public void setDataSource2(DataSource dataSource2) {
        this.dataSource2 = dataSource2;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getDataSource1JoinId() {
        return dataSource1JoinId;
    }

    public void setDataSource1JoinId(String dataSource1JoinId) {
        this.dataSource1JoinId = dataSource1JoinId;
    }

    public String getDataSource2JoinId() {
        return dataSource2JoinId;
    }

    public void setDataSource2JoinId(String dataSource2JoinId) {
        this.dataSource2JoinId = dataSource2JoinId;
    }
}
