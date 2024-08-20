import java.sql.*;

public class WorkerAllocationDAO {

    public void allocateWorker(int projectId, int workerId) {
        String sql = "INSERT INTO Worker_Allocation (Project_ID, Worker_ID) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, projectId);
            stmt.setInt(2, workerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
