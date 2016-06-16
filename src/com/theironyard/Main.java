package com.theironyard;

import jdk.nashorn.internal.parser.JSONParser;
import jodd.json.JsonParser;
import org.h2.tools.Server;
import spark.Spark;

import java.sql.*;

public class Main {

    public static void createTables(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS toilets (id IDENTITY, facility VARCHAR, latitude DOUBLE, longitude DOUBLE, access INT, capacity INT, cleanliness INT)");
    }

    public static void updateToilet(Connection conn, Toilet toilet) throws SQLException
    {
        PreparedStatement stmt = conn.prepareStatement("UPDATE toilets SET facility=?, latitude=?, longitude=?, access=?, capacity=?, cleanliness=? WHERE id = ?");
        stmt.setString(1,toilet.facility);
        stmt.setDouble(2,toilet.lat);
        stmt.setDouble(3,toilet.lon);
        stmt.setInt(4,toilet.access);
        stmt.setInt(5,toilet.capacity);
        stmt.setInt(6,toilet.cleanliness);
        stmt.setInt(7,toilet.id);
    }

    public static void deleteToilet(Connection conn, int id) throws SQLException
    {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM toilets WHERE id = ?");
        stmt.setInt(1,id);
        stmt.execute();
    }

    public static void main(String[] args) throws SQLException {
        Server.createWebServer().start();
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        createTables(conn);

        Spark.externalStaticFileLocation("public");
        Spark.init();

        Spark.get(
                "/flush",
                (request, response) -> {
                    //ArrayList<Toilet> toilets =

                }
        );
        Spark.post(
                "/flush",
                (request, response) -> {

                }
        );
        Spark.put(
                "/flush",
                (request, response) ->
                {
                    String body = request.body();
                    JsonParser p = new JsonParser();
                    Toilet toilet = p.parse(body,Toilet.class);
                    updateToilet(conn, toilet);
                    return"";
                }
        );
        Spark.delete(
                "/flush/:id",
                (request, response) ->
                {
                    int id = Integer.valueOf(request.params(":id"));
                    deleteToilet(conn, id);
                    return"";
                }
        );
    }
}
