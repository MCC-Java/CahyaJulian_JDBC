/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import models.Region;
import dao.RegionDAO;

/**
 *
 * @author User
 */
public class RegionController {
    private RegionDAO rdao;
    
    public RegionController(){
        this.rdao = new RegionDAO();
    }
// Ini memanggil fungsi get all data regions dari dao return daftar regions
    public List<Region> binding() {
        List<Region> regions = new ArrayList<>();
        regions = this.rdao.getRegions();
        return regions;
//        return this.rdao.getRegions();
    }
    
    public String save(String id, String name){
        String result = "Simpan data gagal";
//        int idRegion = Integer.parseInt(id);
//        Region region = new Region(idRegion, name); // boleh di skip idnya soaalnya autoincrement
        Region region =new Region(name);
        if(this.rdao.insert(region)) result = "Simpan data berhasil";
        return result;
    }
    public String edit(String id, String name){
        int regionId = Integer.parseInt(id);
        Region region = new Region(regionId, name);
        if(this.rdao.update(region)) return "Edit data berhasil";
        return "Edit data gagal";
    }
    public String delete(String id){
        int regionId = Integer.parseInt(id);
        if(this.rdao.delete(regionId)) return "Data berhasil dihapus";
        return "Gagal";
    }
    public List<Region> search(String keyword){
        return this.rdao.search(keyword);
    }
    public Region getById(String id){
        return this.rdao.getById(Integer.parseInt(id));
    }
    
}
