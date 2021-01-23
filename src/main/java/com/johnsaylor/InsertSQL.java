package com.johnsaylor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//step,type,amount,nameOrig,oldbalanceOrg,newbalanceOrig,nameDest,oldbalanceDest,newbalanceDest,isFraud,isFlaggedFraud
//1,PAYMENT,9839.64,C1231006815,170136.0,160296.36,M1979787155,0.0,0.0,0,0

public class InsertSQL {
    Connection connection;

    public InsertSQL(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public void addToBatch(String[] row) throws SQLException {
        String query = "INSERT INTO transactions VALUES(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
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
    }


    public void createTable() throws SQLException {
//        stmt.execute("DROP TABLE IF EXISTS customers CASCADE");
//        stmt.execute("CREATE TABLE customers (CustID int, Last_Name"
//                + " char(50), First_Name char(50),Email char(50), "
//                + "Phone_Number char(12))");
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE transactions(" +
                "step int, type char(50),amount decimal, nameOrig char(50)," +
                "oldbalanceOrg decimal,newbalanceOrig decimal, nameDest char(50)," +
                "oldbalanceDest decimal,newbalanceDest decimal,isFraud decimal,isFlaggedFraud int" +
                ")");
    }
}
