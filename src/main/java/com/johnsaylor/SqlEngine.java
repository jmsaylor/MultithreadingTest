package com.johnsaylor;

import java.sql.*;
import java.util.Arrays;

//step,type,amount,nameOrig,oldbalanceOrg,newbalanceOrig,nameDest,oldbalanceDest,newbalanceDest,isFraud,isFlaggedFraud
//1,PAYMENT,9839.64,C1231006815,170136.0,160296.36,M1979787155,0.0,0.0,0,0

//TODO is db.close() required? also, autocommit settings?

public class SqlEngine {
    private final Connection connection = DBConnect.connect();
    private final String query = "INSERT INTO transactions (step,type,amount,nameOrig,oldbalanceOrg,newbalanceOrig,nameDest,oldbalanceDest,newbalanceDest,isFraud,isFlaggedFraud) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private PreparedStatement preparedStatement;

    public SqlEngine() throws SQLException, ClassNotFoundException {
        if (connection == null) throw new SQLException("Failure to connect");
        this.preparedStatement = connection.prepareStatement(query);
        createTable();
    }

    public void addToBatch(String data) throws SQLException {

        String[] row = data.split(",");

        //step
        preparedStatement.setInt(1, Integer.parseInt(row[0]));
        //type
        preparedStatement.setString(2, row[1]);
        //amount
        preparedStatement.setFloat(3, Float.parseFloat(row[2]));
        //nameOrig
        preparedStatement.setString(4, row[3]);
//        oldbalanceOrg,
        preparedStatement.setFloat(5, Float.parseFloat(row[4]));
//        newbalanceOrig,
        preparedStatement.setFloat(6, Float.parseFloat(row[5]));
//        nameDest,
        preparedStatement.setString(7, row[6]);
//        oldbalanceDest,
        preparedStatement.setFloat(8, Float.parseFloat(row[7]));
//        newbalanceDest,
        preparedStatement.setFloat(9, Float.parseFloat(row[8]));
//        isFraud,
        preparedStatement.setFloat(10, Float.parseFloat(row[9]));
//        isFlaggedFraud
        preparedStatement.setInt(11, Integer.parseInt(row[10]));

        //TODO separate concerns
        preparedStatement.addBatch();

        executeBatch();

    }

    public void executeBatch() throws SQLException {
        var result = preparedStatement.executeBatch();
        System.out.println(Arrays.toString(result));
    }


    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE IF EXISTS transactions CASCADE");
        statement.execute("CREATE TABLE transactions(" +
                "step int, type char(20),amount decimal, nameOrig char(20)," +
                "oldbalanceOrg decimal,newbalanceOrig decimal, nameDest char(20)," +
                "oldbalanceDest decimal,newbalanceDest decimal,isFraud decimal,isFlaggedFraud int" +
                ")");
    }


}
