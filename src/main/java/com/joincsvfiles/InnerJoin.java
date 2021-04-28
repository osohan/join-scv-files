package com.joincsvfiles;

import java.util.*;

public class InnerJoin extends JoinOperation {

    public InnerJoin(DataSource dataSource1, DataSource dataSource2, String joinIdInDataSource1, String joinIdInDataSource2) {
        super(dataSource1, dataSource2, joinIdInDataSource1, joinIdInDataSource2);
    }

    public List<String[]> join(Integer limit, Integer offset, OrderBy orderBy) {
        List<String[]> result = new ArrayList<>();

        Map<String, List<String[]>> dataSource1FieldValuesMap = new HashMap<>();
        String[] dataSource1FieldValues = null;
        while ((dataSource1FieldValues = getDataSource1().getNextFieldValues()) != null) {
            List<String[]> fieldValuesList = dataSource1FieldValuesMap.get(dataSource1FieldValues[getJoinIdIndexInDataSource1()]);
            if (fieldValuesList == null) {
                fieldValuesList = new LinkedList<>();
                dataSource1FieldValuesMap.put(dataSource1FieldValues[getJoinIdIndexInDataSource1()], fieldValuesList);
            }
            fieldValuesList.add(dataSource1FieldValues);
        }

        String[] dataSource2FieldValues = null;
        while ((dataSource2FieldValues = getDataSource2().getNextFieldValues()) != null) {
            String joinValue = dataSource2FieldValues[getJoinIdIndexInDataSource2()];
            List<String[]> data = dataSource1FieldValuesMap.get(joinValue);
            if (data != null) {
                for (String[] values : data) {
                    int globalIndex = 0;
                    String[] rowValues = new String[values.length + dataSource2FieldValues.length];
                    for (int i = 0; i < values.length; i++) {
                        rowValues[globalIndex++] = values[i];
                    }
                    for (int i = 0; i < dataSource2FieldValues.length; i++) {
                        rowValues[globalIndex++] = dataSource2FieldValues[i];
                    }
                    result.add(rowValues);
                }
            }
        }
        Collections.sort(result, orderBy);
        return result;
    }
}
