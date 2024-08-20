import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {

    public void insert(Project project) {
        String sql = "INSERT INTO Project (Project_Name, Location, Start_Date, End_Date) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, project.getProjectName());
            stmt.setString(2, project.getLocation());
            stmt.setString(3, project.getStartDate());
            stmt.setString(4, project.getEndDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Project> list() {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM Project";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Project project = new Project();
                project.setProjectId(rs.getInt("Project_ID"));
                project.setProjectName(rs.getString("Project_Name"));
                project.setLocation(rs.getString("Location"));
                project.setStartDate(rs.getString("Start_Date"));
                project.setEndDate(rs.getString("End_Date"));
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }
}
