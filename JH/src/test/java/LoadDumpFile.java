import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;

//public class LoadDumpFile {
//
//    public static void main(String[] args) {
//        String jdbcUrl = "jdbc:h2:file:./target/h2db/db/jh";
//        String username = "jh";
//        String password = "";
//        String dumpFilePath = "JH/src/main/resources/config/dump.sql";
//
//        try {
//            // Connect to the database
//            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
//            Statement statement = connection.createStatement();
//
//            // Read and execute SQL script from the dump file
//            BufferedReader reader = new BufferedReader(new FileReader(dumpFilePath));
//            String line;
//            StringBuilder script = new StringBuilder();
//            while ((line = reader.readLine()) != null) {
//                script.append(line).append("\n");
//            }
//            reader.close();
//
//            // Execute the script
//            statement.executeUpdate(script.toString());
//
//            // Close resources
//            statement.close();
//            connection.close();
//
//            System.out.println("Dump file loaded successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
