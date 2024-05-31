package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {
    private static HikariDataSource dataSource;

    static {
        try {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mysql://localhost:3306/db_school_eorder");
            config.setUsername("root");
            config.setPassword("yyh66666.");
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            dataSource = new HikariDataSource(config);
            System.out.println("HikariCP DataSource initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to initialize HikariCP DataSource: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static List<String> getComments() {
        List<String> comments = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT content FROM tb_comment")) {
            while (rs.next()) {
                comments.add(rs.getString("content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}
