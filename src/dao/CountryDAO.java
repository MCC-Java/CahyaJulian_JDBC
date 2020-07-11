/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import models.Region;
import tools.MyConnection;

/**
 *
 * @author User
 */
public class CountryDAO {
    
    private Connection connection = null;
    
    public CountryDAO() {
        this.connection = new MyConnection().getConnection();
    }

//    mengambil semua data dari database
    public List<Country> getCountrys() {
        List<Country> countrys = new ArrayList<>();
        String sql = "select * from country c left join region r on c.region = r.id;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getString(1));
                country.setName(resultSet.getString(2));
                country.setRegion(resultSet.getInt(3));
                countrys.add(country);
                
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }
        return countrys;
    }

    public boolean insert(Country country) {
        boolean result = false;
        String sql = "INSERT INTO country(id, name, region) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, country.getId());
            statement.setString(2, country.getName());
            statement.setInt(3, country.getRegion());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean update(Country country) {
        boolean result = false;
        String sql = "UPDATE country SET name=?, region=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, country.getName());
            statement.setString(3, country.getId());
            statement.setInt(2, country.getRegion());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        String sql = "DELETE FROM country WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Country> search(String keyword) {
        List<Country> countrys = new ArrayList<>();
        String sql = "SELECT * FROM country WHERE id LIKE ? OR name LIKE ? OR region LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {                
                Country country = new Country();
                country.setId(resultSet.getString("id"));
                country.setName(resultSet.getString("name"));
                country.setRegion(resultSet.getInt(3));
                countrys.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countrys;
    }
    
    public Country getById(String id) {
        Country country = null;
        String sql = "SELECT * FROM country WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {                
                country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }
    
}
