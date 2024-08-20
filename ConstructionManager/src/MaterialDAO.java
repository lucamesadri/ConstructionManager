import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    public void insert(Material material) {
        String sql = "INSERT INTO Material (Material_Name, Quantity) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, material.getMaterialName());
            stmt.setInt(2, material.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Material> list() {
        List<Material> materials = new ArrayList<>();
        String sql = "SELECT * FROM Material";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Material material = new Material();
                material.setMaterialId(rs.getInt("Material_ID"));
                material.setMaterialName(rs.getString("Material_Name"));
                material.setQuantity(rs.getInt("Quantity"));
                materials.add(material);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materials;
    }
}
