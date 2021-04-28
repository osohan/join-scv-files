package com.joincsvfiles;

import com.joincsvfiles.exceptions.EmptyFileException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CsvDataSourceBase implements DataSource {

    private String[] fieldNames;
    private Integer currentIndex = 0;
    private List<String[]> data = new LinkedList<>();

    public CsvDataSourceBase(String filePath) {
        File file = new File(filePath);
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line == null) throw new EmptyFileException();
                this.fieldNames = line.split(";");
                while ((line = br.readLine()) != null) {
                    data.add(line.split(";"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String[] getFieldNames() {
        return fieldNames;
    }

    @Override
    public String[] getNextFieldValues() {
        if (currentIndex >= data.size()) return null;
        return data.get(currentIndex++);
    }
}
