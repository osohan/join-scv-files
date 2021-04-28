package com.joincsvfiles;

import com.joincsvfiles.exceptions.JoinIdNotPresentedException;

import java.util.List;

public abstract class JoinOperation {

    private DataSource dataSource1;
    private DataSource dataSource2;
    private String joinIdInDataSource1;
    private String joinIdInDataSource2;
    private Integer joinIdIndexInDataSource1;
    private Integer joinIdIndexInDataSource2;
    private String[] joinedFieldNames;

    public JoinOperation(DataSource dataSource1, DataSource dataSource2, String joinIdInDataSource1, String joinIdInDataSource2) {
        this.dataSource1 = dataSource1;
        this.dataSource2 = dataSource2;
        this.joinIdInDataSource1 = joinIdInDataSource1;
        this.joinIdInDataSource2 = joinIdInDataSource2;

        this.joinIdIndexInDataSource1 = getJoinIdIndexInFieldNames(dataSource1, joinIdInDataSource1);
        this.joinIdIndexInDataSource2 = getJoinIdIndexInFieldNames(dataSource2, joinIdInDataSource2);

        setJoinedFieldNames();
    }

    public String[] getJoinedFieldNames() {
        return joinedFieldNames;
    }

    private void setJoinedFieldNames() {
        int index = 0;
        this.joinedFieldNames = new String[dataSource1.getFieldNames().length + dataSource2.getFieldNames().length];
        for (String v : dataSource1.getFieldNames()) {
            this.joinedFieldNames[index++] = "datasource1:" + v;
        }
        for (String v : dataSource2.getFieldNames()) {
            this.joinedFieldNames[index++] = "datasource2:" + v;
        }
    }

    abstract List<String[]> join(Integer limit, Integer offset, OrderBy orderBy);

    public Integer getJoinIdIndexInFieldNames(DataSource dataSource, String joinIdInData) {
        for (int i = 0; i < dataSource.getFieldNames().length; i++) {
            if (dataSource.getFieldNames()[i].equals(joinIdInData)) {
                return i;
            }
        }
        throw new JoinIdNotPresentedException();
    }

    public DataSource getDataSource1() {
        return dataSource1;
    }

    public DataSource getDataSource2() {
        return dataSource2;
    }

    public String getJoinIdInDataSource1() {
        return joinIdInDataSource1;
    }

    public String getJoinIdInDataSource2() {
        return joinIdInDataSource2;
    }

    public Integer getJoinIdIndexInDataSource1() {
        return joinIdIndexInDataSource1;
    }

    public Integer getJoinIdIndexInDataSource2() {
        return joinIdIndexInDataSource2;
    }
}
