package com.joincsvfiles;

import com.joincsvfiles.exceptions.EmptyFileException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ApplicationTest {

    @Test
    public void simpleTest() {
        CommunicationInterface communicationInterface = new CommunicationInterfaceFactory().getInputData(CommunicationType.CONSOLE_WITH_BASE_DATA);
        InputData inputData = communicationInterface.getData();
        JoinOperation joinOperation = JoinOperationFactory.get(inputData);
        List<String[]> result = joinOperation.join(null, null, new DefaultOrderBy(joinOperation.getJoinIdIndexInDataSource2()));

        FilterSelectedFieldsResult filterSelectedFieldsResult = new FilterSelectedFieldsBase().filter(inputData.getSelectFields(), joinOperation.getJoinedFieldNames(), result);

        assertTrue(filterSelectedFieldsResult.getResult().size() == 7);
        assertTrue(Arrays.equals(filterSelectedFieldsResult.getHeader(), new String[]{"name", "surname", "department_name"}));

        assertTrue(Arrays.equals(filterSelectedFieldsResult.getResult().get(0), new String[]{"John", "Smith", "Management"}));
        assertTrue(Arrays.equals(filterSelectedFieldsResult.getResult().get(filterSelectedFieldsResult.getResult().size() - 1), new String[]{"Nicol", "Green", "Management"}));
    }

    @Test
    public void emptyDatasourceTest() {
        boolean emptyFileException = false;
        try {
            new CsvDataSourceBase("C:\\Users\\osokhan\\IdeaProjects\\join-csv-files\\src\\main\\resources\\empty.csv");
        } catch (EmptyFileException ex) {
            emptyFileException = true;
        }
        assertTrue(emptyFileException);
    }


}
