/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CountryDAO;
import java.util.List;
import models.Country;

/**
 *
 * @author User
 */
public class CountryController {
    private CountryDAO cdao;
    
    public  CountryController(){
        this.cdao = new CountryDAO();
    }
//    untuk memanggil fungsi get all data country
   public List<Country> binding(){
       return this.cdao.getCountrys();
   }
//    untuk menyimpan data
   public String save(String id, String name, int region){
       String result = "Simpan data gagal";
       Country country = new Country(id, name, region);
       if(this.cdao.insert(country)) result = "Simpan data berhasil";
       return result;
   }
   public String edit(String id, String name, String region){
       int regionId = Integer.parseInt(region);
       Country country = new Country(id, name, regionId);
       if(this.cdao.update(country)) return "Edit data berhasil";
       return "Gagal";
   }
   public String delete(String id){
       if(this.cdao.delete(id)) return "Data berhasil dihapus";
       return "Gagal";
   }
   public List<Country> search(String keyword){
       return this.cdao.search(keyword);
   }
   public Country getById(String id){
       return this.cdao.getById(id);
   }
}
