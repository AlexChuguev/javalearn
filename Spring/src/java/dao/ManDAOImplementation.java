/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Man;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexey
 */
@Repository
public class ManDAOImplementation  implements ManDAO{
    
    @Autowired
    private DataSource dataSource;

    @Override
    public List<Man> listAllMans() {
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM man";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet res = stmt.executeQuery();
            List<Man> pets = new ArrayList<>();
            while (res.next()) {
                Man man = new Man();
                man.setId(res.getInt(1));
                man.setName(res.getString(2));
               
                man.setBirth(res.getDate(6));
              
                pets.add(man);

            }
            return pets;
        } catch (Exception ex) {
            throw new RuntimeException("An error has occured in lisPets methos", ex);
        }

    }
    
    @Override
    public  Man getManById(Integer petId) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "Select name, birth FROM man where id=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, petId);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                Man man = new Man();
                man.setId(petId);
                man.setName(res.getString(1));
               
                man.setBirth(res.getDate(5));
            
                return man;
            } else {
                return null;
            }

        } catch (Exception ex) {
            throw new RuntimeException("An error has occured in getPetById method", ex);
        }
    }

    @Override
    public int addMan(Man man){
        try(Connection connection = dataSource.getConnection()){
            String query = "INSERT INTO MAN "
                    + "(name,birth)"
                    + "VALUES(?,?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, man.getName());
            stmt.setDate(2, man.getBirth());
           
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
            else{
                throw new RuntimeException("An error has occured in adding data to database");
            }
        }catch(Exception ex){
            throw new RuntimeException("Ann error has occured in addPet method", ex);
        }
    }
    

    @Override
    public boolean editMan(Man man) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "UPDATE man SET name=?,birth=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, man.getName());
            stmt.setDate(2, man.getBirth());          
            stmt.execute();
            return true;
        } catch (Exception ex) {
            throw new RuntimeException("An error has occured in editPet method", ex);
        }
    }

    @Override
    public boolean deleteMan(Man man) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "DELETE FROM man where id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, man.getId());
            statement.execute();
            return true;
        } catch (Exception ex) {
            throw new RuntimeException("An error has occured in deletePet method", ex);
        }
    }
}
