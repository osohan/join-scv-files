package com.joincsvfiles;

public class SelectField {
    private String datasourceName;
    private String fieldName;
    private String aliasName;

    public SelectField(String datasourceName, String fieldName, String aliasName) {
        this.datasourceName = datasourceName;
        this.fieldName = fieldName;
        this.aliasName = aliasName;
    }

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }
}
