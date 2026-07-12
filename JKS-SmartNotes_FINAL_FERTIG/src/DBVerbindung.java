
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBVerbindung {

    private static final Logger dbProtokoll = Logger.getLogger(DBVerbindung.class.getName());

    private final String host;
    private final int port;
    private final String dbName;
    private final String username;
    private final String password;
    private Connection Verbindung;

    public DBVerbindung(String host, int port, String dbName, String username, String password) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

    public void connect() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://"
               + this.host + ":" + this.port + "/" + this.dbName
               + "?useSSL=false"
               + "&allowPublicKeyRetrieval=true"
               + "&serverTimezone=Europe/Berlin";
    Verbindung = DriverManager.getConnection(url, this.username, this.password);
    dbProtokoll.info("Verbindung zur Datenbank hergestellt: " + this.dbName);
}


    public Connection getVerbindung() {
        return this.Verbindung;
    }

    public void close() throws SQLException {
        if (this.Verbindung != null && !this.Verbindung.isClosed()) {
            this.Verbindung.close();
            dbProtokoll.info("Verbindung zur Datenbank geschlossen: " + this.dbName);
        }
    }

    public ResultSet executeSelect(String query) throws SQLException {
        try {
            PreparedStatement preparedStatement = Verbindung.prepareStatement(query);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            dbProtokoll.log(Level.SEVERE, "Fehler beim Ausführen des SELECTS-Befehl: " + e.getMessage(), e);
            throw e;
        }
    }

    public ResultSet executeSelectP(String query, Object... params) throws SQLException {
        PreparedStatement preparedStatement = Verbindung.prepareStatement(query);
        setParameters(preparedStatement, params);
        return preparedStatement.executeQuery();
    }

    public int executeInsert(String sql, Object... params) throws SQLException {
        try (PreparedStatement stmt = Verbindung.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Set parameters
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            // Execute insert
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Einfügen fehlgeschlagen, keine Zeilen betroffen,");
            }

            // Retrieve auto-generated keys
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    System.out.println("Eingefügter Datensatz mit ID: " + id);
                    return id;

                } else {
                    throw new SQLException("Fehler beim Abrufen der eingefügten ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Fehler beim Ausführen des INSERT-Befehls: " + e.getMessage());
            throw e; // Rethrow the exception for handling in your GUI method
        }
    }

    public int executeInsertR(String sql, Object... params) throws SQLException {
        try (PreparedStatement stmt = Verbindung.prepareStatement(sql)) {

            // Set parameters
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            // Execute insert
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Einfügen fehlgeschlagen, keine Zeilen betroffen..");
            }

            // Return a meaningful value, such as the number of affected rows
            return affectedRows;

        } catch (SQLException e) {
            System.err.println("Fehler beim Ausführen des INSERT-Befehls: " + e.getMessage());
            throw e; // Rethrow the exception for handling in your GUI method or UI layer
        }
    }

    public int executeUpdate(String query, Object... values) throws SQLException {
        try {
            PreparedStatement preparedStatement = Verbindung.prepareStatement(query);
            setParameters(preparedStatement, values);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            dbProtokoll.log(Level.SEVERE, "Fehler beim Ausführen des : " + e.getMessage(), e);
            throw e;
        }
    }

    private void setParameters(PreparedStatement preparedStatement, Object... values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setObject(i + 1, values[i]);
        }
    }
}
