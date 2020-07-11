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
import models.Region;
import tools.MyConnection;

/**
 *
 * @author User
 */
public class RegionDAO {

    private Connection connection = null;

    public RegionDAO() {
        this.connection = new MyConnection().getConnection();
    }
//    ini meerupakan suatu fungsi untuk megambil semua data dari database

    public List<Region> getRegions() {
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM region";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region();
                region.setId(resultSet.getInt("id"));
                region.setName(resultSet.getString("name"));
                regions.add(region);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }
//    untuk memasukan data region baru
//    @param region satu objek utuh dari region, yg mempunyai id dan name
//    @return boolean true kalo berhasil

    public boolean insert(Region region) {
        boolean result = false;
        String query = "INSERT INTO Region(id, name) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, region.getId());
            statement.setString(2, region.getName());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Region region) {
        boolean result = false;
        String sql = "UPDATE region SET name=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(2, region.getId());
            statement.setString(1, region.getName());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public boolean delete(int id) {
        boolean result = false;
        String sql = "DELETE FROM region WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Region getById(int id) {
        Region region = null;
        String query = "SELECT * FROM region WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                region = new Region(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return region;
    }

    public List<Region> search(String keyword) {
        List<Region> regions = new ArrayList<>();
        String sql = "SELECT * FROM region WHERE id LIKE ? OR name LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region();
                region.setId(resultSet.getInt("id"));
                region.setName(resultSet.getString("name"));
                regions.add(region);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }
}
