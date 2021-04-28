package com.joincsvfiles;

import java.util.List;

public class FilterSelectedFieldsResult {
    private String[] header;
    private List<String[]> result;

    public FilterSelectedFieldsResult(String[] header, List<String[]> result) {
        this.header = header;
        this.result = result;
    }

    public String[] getHeader() {
        return header;
    }

    public List<String[]> getResult() {
        return result;
    }
}
