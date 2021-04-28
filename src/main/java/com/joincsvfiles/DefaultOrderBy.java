package com.joincsvfiles;

public class DefaultOrderBy implements OrderBy {

    private Integer indexOfSortingField;

    public DefaultOrderBy(Integer indexOfSortingField) {
        this.indexOfSortingField = indexOfSortingField;
    }

    @Override
    public int compare(String[] o1, String[] o2) {
        return o1[indexOfSortingField].compareTo(o2[indexOfSortingField]);
    }
}
