import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

    public class HeidiDb {
        // JDBC URL, username e password del database MySQL
        private static final String DB_URL = "jdbc:mysql://localhost:3306/develhope";
        private static final String USER = "root";
        private static final String PASSWORD = ",$rZ8JgBeUbR#cw";

        public static void main(String[] args) {

            Connection conn = null;
            Statement stmt = null;

            try {
                // Registra il driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Apri una connessione al database
                conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

                // Crea una dichiarazione SQL
                stmt = conn.createStatement();

                // Query per creare la tabella students se non esiste già
                String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                        "student_id INT(10) NOT NULL AUTO_INCREMENT," +
                        "last_name VARCHAR(30)," +
                        "first_name VARCHAR(30)," +
                        "PRIMARY KEY (student_id)" +
                        ")";

                // Esegui la query per creare la tabella
                stmt.executeUpdate(createTableSQL);

                String insertStudent1SQL = "INSERT INTO students (last_name, first_name) VALUES ('Tassone', 'Giuseppe')";
                String insertStudent2SQL = "INSERT INTO students (last_name, first_name) VALUES ('Benedetti', 'Simone')";
                String insertStudent3SQL = "INSERT INTO students (last_name, first_name) VALUES ('Caporaso', 'Claudio')";
                String insertStudent4SQL = "INSERT INTO students (last_name, first_name) VALUES ('Zora', 'Andrea')";

                stmt.executeUpdate(insertStudent1SQL);
                stmt.executeUpdate(insertStudent2SQL);
                stmt.executeUpdate(insertStudent3SQL);
                stmt.executeUpdate(insertStudent4SQL);

                System.out.println("Tabella students creata con successo!");

            } catch (SQLException se) {
                // Gestione degli errori per SQL
                se.printStackTrace();
            } catch (Exception e) {
                // Gestione degli errori per il caricamento del driver JDBC
                e.printStackTrace();
            } }}