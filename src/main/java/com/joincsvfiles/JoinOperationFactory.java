package com.joincsvfiles;

import com.joincsvfiles.exceptions.UnsupportedJoinOperationException;

public class JoinOperationFactory {

    public static JoinOperation get(InputData inputData) {
        switch (inputData.getOperation()) {
            case INNER_JOIN: return new InnerJoin(inputData.getDataSource1(), inputData.getDataSource2(), inputData.getDataSource1JoinId(), inputData.getDataSource2JoinId());
        }
        throw new UnsupportedJoinOperationException();
    }

}
