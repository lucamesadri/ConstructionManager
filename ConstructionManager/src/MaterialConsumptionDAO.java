import java.sql.*;

public class MaterialConsumptionDAO {

    public void useMaterial(int projectId, int materialId) {
        String sql = "INSERT INTO Material_Usage (Project_ID, Material_ID) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, projectId);
            stmt.setInt(2, materialId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

