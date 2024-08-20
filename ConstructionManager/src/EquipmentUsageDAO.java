import java.sql.*;

public class EquipmentUsageDAO {

    public void useEquipment(int projectId, int equipmentId) {
        String sql = "INSERT INTO Equipment_Usage (Project_ID, Equipment_ID) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, projectId);
            stmt.setInt(2, equipmentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
