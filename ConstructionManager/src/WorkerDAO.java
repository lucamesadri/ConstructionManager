import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerDAO {

    public void insert(Worker worker) {
        String sql = "INSERT INTO Worker (Worker_Name, Role) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, worker.getWorkerName());
            stmt.setString(2, worker.getRole());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Worker> list() {
        List<Worker> workers = new ArrayList<>();
        String sql = "SELECT * FROM Worker";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Worker worker = new Worker();
                worker.setWorkerId(rs.getInt("Worker_ID"));
                worker.setWorkerName(rs.getString("Worker_Name"));
                worker.setRole(rs.getString("Role"));
                workers.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workers;
    }
}
