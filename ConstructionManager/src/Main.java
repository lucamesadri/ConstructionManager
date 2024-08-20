public class Main {

    public static void main(String[] args) {
        CreateTables createTables = new CreateTables();
        createTables.createTables();

        ProjectDAO projectDAO = new ProjectDAO();
        EngineerDAO engineerDAO = new EngineerDAO();
        WorkerDAO workerDAO = new WorkerDAO();
        EquipmentDAO equipmentDAO = new EquipmentDAO();
        MaterialDAO materialDAO = new MaterialDAO();
        EngineerAllocationDAO engineerAllocationDAO = new EngineerAllocationDAO();
        WorkerAllocationDAO workerAllocationDAO = new WorkerAllocationDAO();
        EquipmentUsageDAO equipmentUsageDAO = new EquipmentUsageDAO();
        MaterialConsumptionDAO materialConsumptionDAO = new MaterialConsumptionDAO();

        Project project = new Project();
        project.setProjectName("New Building");
        project.setLocation("Downtown");
        project.setStartDate("2024-09-01");
        project.setEndDate("2025-01-01");
        projectDAO.insert(project);

        Engineer engineer = new Engineer();
        engineer.setEngineerName("John Doe");
        engineer.setSpecialty("Civil Engineering");
        engineerDAO.insert(engineer);
    }
}
