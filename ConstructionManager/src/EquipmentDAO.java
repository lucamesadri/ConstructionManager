import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO {

    public void insert(Equipment equipment) {
        String sql = "INSERT INTO Equipment (Equipment_Name, Type) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, equipment.getEquipmentName());
            stmt.setString(2, equipment.getType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Equipment> list() {
        List<Equipment> equipments = new ArrayList<>();
        String sql = "SELECT * FROM Equipment";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Equipment equipment = new Equipment();
                equipment.setEquipmentId(rs.getInt("Equipment_ID"));
                equipment.setEquipmentName(rs.getString("Equipment_Name"));
                equipment.setType(rs.getString("Type"));
                equipments.add(equipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipments;
    }
}
