package com.joincsvfiles;

import java.util.ArrayList;
import java.util.List;

public class FilterSelectedFieldsBase implements FilterSelectedFields {

    public FilterSelectedFieldsResult filter(SelectField[] selectFields, String[] fieldNames, List<String[]> result) {
        String[] fieldNamesToDisplay = new String[selectFields.length];
        int[] fieldIndexesToDisplay = new int[selectFields.length];

        int index = 0;
        for (int i = 0; i < fieldNames.length; i++) {
            for (SelectField selectField : selectFields) {
                if (fieldNames[i].equals(selectField.getDatasourceName() + ":" + selectField.getFieldName())) {
                    fieldIndexesToDisplay[index] = i;
                    fieldNamesToDisplay[index] = selectField.getAliasName() != null ? selectField.getAliasName() : selectField.getFieldName();
                    index++;
                    break;
                }
            }
        }

        List<String[]> selectedResult = new ArrayList<>(result.size());
        for (String[] dataRow : result) {
            String[] dataRowSelectedFields = new String[selectFields.length];
            int cursor = 0;
            for (int i : fieldIndexesToDisplay) {
                dataRowSelectedFields[cursor++] = dataRow[i];
            }
            selectedResult.add(dataRowSelectedFields);
        }

        return new FilterSelectedFieldsResult(fieldNamesToDisplay, selectedResult);
    }

}
