package com.joincsvfiles;

public interface DataSource {
    String[] getFieldNames();
    String[] getNextFieldValues();
}
