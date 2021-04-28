package com.joincsvfiles;

import java.util.List;

public interface FilterSelectedFields {
    FilterSelectedFieldsResult filter(SelectField[] selectFields, String[] fieldNames, List<String[]> result);
}
