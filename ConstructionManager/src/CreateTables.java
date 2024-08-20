import java.sql.*;

public class CreateTables {

    public void createTables() {
        String sqlProject = "CREATE TABLE IF NOT EXISTS Project (Project_ID INTEGER PRIMARY KEY AUTOINCREMENT, Project_Name TEXT, Location TEXT, Start_Date TEXT, End_Date TEXT)";
        String sqlEngineer = "CREATE TABLE IF NOT EXISTS Engineer (Engineer_ID INTEGER PRIMARY KEY AUTOINCREMENT, Engineer_Name TEXT, Specialty TEXT)";
        String sqlWorker = "CREATE TABLE IF NOT EXISTS Worker (Worker_ID INTEGER PRIMARY KEY AUTOINCREMENT, Worker_Name TEXT, Role TEXT)";
        String sqlEquipment = "CREATE TABLE IF NOT EXISTS Equipment (Equipment_ID INTEGER PRIMARY KEY AUTOINCREMENT, Equipment_Name TEXT, Type TEXT)";
        String sqlMaterial = "CREATE TABLE IF NOT EXISTS Material (Material_ID INTEGER PRIMARY KEY AUTOINCREMENT, Material_Name TEXT, Quantity INTEGER)";
        String sqlEngineerAllocation = "CREATE TABLE IF NOT EXISTS Engineer_Allocation (Project_ID INTEGER, Engineer_ID INTEGER, PRIMARY KEY (Project_ID, Engineer_ID), FOREIGN KEY (Project_ID) REFERENCES Project(Project_ID), FOREIGN KEY (Engineer_ID) REFERENCES Engineer(Engineer_ID))";
        String sqlWorkerAllocation = "CREATE TABLE IF NOT EXISTS Worker_Allocation (Project_ID INTEGER, Worker_ID INTEGER, PRIMARY KEY (Project_ID, Worker_ID), FOREIGN KEY (Project_ID) REFERENCES Project(Project_ID), FOREIGN KEY (Worker_ID) REFERENCES Worker(Worker_ID))";
        String sqlEquipmentUsage = "CREATE TABLE IF NOT EXISTS Equipment_Usage (Project_ID INTEGER, Equipment_ID INTEGER, PRIMARY KEY (Project_ID, Equipment_ID), FOREIGN KEY (Project_ID) REFERENCES Project(Project_ID), FOREIGN KEY (Equipment_ID) REFERENCES Equipment(Equipment_ID))";
        String sqlMaterialConsumption = "CREATE TABLE IF NOT EXISTS Material_Consumption (Project_ID INTEGER, Material_ID INTEGER, PRIMARY KEY (Project_ID, Material_ID), FOREIGN KEY (Project_ID) REFERENCES Project(Project_ID), FOREIGN KEY (Material_ID) REFERENCES Material(Material_ID))";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement stmt = connection.createStatement()) {

            stmt.execute(sqlProject);
            stmt.execute(sqlEngineer);
            stmt.execute(sqlWorker);
            stmt.execute(sqlEquipment);
            stmt.execute(sqlMaterial);
            stmt.execute(sqlEngineerAllocation);
            stmt.execute(sqlWorkerAllocation);
            stmt.execute(sqlEquipmentUsage);
            stmt.execute(sqlMaterialConsumption);

            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
