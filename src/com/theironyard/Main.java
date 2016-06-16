package com.theironyard;

import org.h2.tools.Server;
import spark.Spark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void createTables(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS toilets (id IDENTITY, facility VARCHAR, latitude DOUBLE, longitude DOUBLE, access INT, capacity INT, cleanliness INT)");
    }

//    public static ArrayList<Toilet> selectToilets(Connection conn) {
//
//    }

    public static void main(String[] args) throws SQLException {
        Server.createWebServer().start();
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        createTables(conn);

        Spark.externalStaticFileLocation("public");
        Spark.init();

//        Spark.get(
//                "/flush",
//                (request, response) -> {
//                    //ArrayList<Toilet> toilets =
//
//                }
//        );
//        Spark.post(
//                "/flush",
//                (request, response) -> {
//
//                }
//        );
//        Spark.put(
//                "/flush",
//                (request, response) -> {
//
//                }
//        );
//        Spark.delete(
//                "/flush",
//                (request, response) -> {
//
//                }
//        );






    }
}
