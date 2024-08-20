import java.sql.*;

public class EngineerAllocationDAO {

    public void allocateEngineer(int projectId, int engineerId) {
        String sql = "INSERT INTO Engineer_Allocation (Project_ID, Engineer_ID) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, projectId);
            stmt.setInt(2, engineerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
