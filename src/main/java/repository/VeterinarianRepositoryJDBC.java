package repository;

import connection.DataBaseUtils;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VeterinarianRepositoryJDBC {

    public void save(String firstName, String lastName, String address, String speciality) {
        DataBaseUtils dataBaseUtils = new DataBaseUtils();
        if (dataBaseUtils.getConnection() != null) ;
        try {
            Statement statement = dataBaseUtils.getConnection().createStatement();
            String sqlOperation =
                    "INSERT veterinarian(firstName, lastName, address, speciality) VALUES" +
                            "( '" + firstName + "' , '" + lastName + "' , '" + address + "' , '" + speciality + "')";
            System.out.println("SQL Operation is:" + sqlOperation);
            statement.executeUpdate(sqlOperation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void viewAllVeterinarians(){
        DataBaseUtils dataBaseUtils = new DataBaseUtils();
        if(dataBaseUtils.getConnection() != null){
            String sqlOperation = "SELECT id, firstName, lastName FROM petclinic";
            try {
                Statement statement = dataBaseUtils.getConnection().createStatement();
                ResultSet rs = statement.executeQuery(sqlOperation);
                while(rs.next()) {
                    int id = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    System.out.println("id= " + id + "firstName= " + firstName + "lastName =" + lastName);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void update(int id, String firstName){
        DataBaseUtils dataBaseUtils = new DataBaseUtils();
        if(dataBaseUtils.getConnection() != null){
            try {
                Statement statement = dataBaseUtils.getConnection().createStatement();
                String sqlOperation = "UPDATE petclinic SET firstName='" + firstName + "'WHERE id = " + id;
                statement.executeUpdate(sqlOperation);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void delete(int id){
        DataBaseUtils dataBaseUtils = new DataBaseUtils();
        if(dataBaseUtils.getConnection() !=null){
            try {
                Statement statement = dataBaseUtils.getConnection().createStatement();
                String sqlOperation = "DELETE FROM petclinic WHERE id=" + id;
                statement.executeUpdate(sqlOperation);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
