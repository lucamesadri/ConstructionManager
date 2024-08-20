import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EngineerDAO {

    public void insert(Engineer engineer) {
        String sql = "INSERT INTO Engineer (Engineer_Name, Specialty) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, engineer.getEngineerName());
            stmt.setString(2, engineer.getSpecialty());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Engineer> list() {
        List<Engineer> engineers = new ArrayList<>();
        String sql = "SELECT * FROM Engineer";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Engineer engineer = new Engineer();
                engineer.setEngineerId(rs.getInt("Engineer_ID"));
                engineer.setEngineerName(rs.getString("Engineer_Name"));
                engineer.setSpecialty(rs.getString("Specialty"));
                engineers.add(engineer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return engineers;
    }
}
