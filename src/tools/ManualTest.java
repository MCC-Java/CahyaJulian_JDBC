/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controller.CountryController;
import controller.RegionController;
import java.util.List;
import models.Country;
import models.Region;

/**
 *
 * @author User
 */
public class ManualTest {

//   == untuk region ==
//    public static void main(String[] args) {
////        System.out.println(new MyConnection().getConnection());
//        RegionController controller = new RegionController();
////insert data regions
////        System.out.println(controller.save("", "Finlandia"));
//////  update data regions
////System.out.println(controller.edit("5", "Antartika"));
////hapus data
////        System.out.println(controller.delete("7"));
////        List<Region> regions = controller.search("ka");
//// menampilkan data
////        List<Region> regionList = controller.binding();
////        for (Region region : regions) {
////            System.out.println("id: " + region.getId() + ", name: " + region.getName());
////        }
//
////        get by id
//        Region region = controller.getById("2");
//        System.out.println(region.getId());
//        System.out.println(region.getName());
//
//    }
//   == untuk country ==
    public static void main(String[] args) {
        CountryController controller = new CountryController();
////        System.out.println(controller.save("9", "Korea Selatan", 1));
////        System.out.println(controller.edit("5", "Selandia Baru", "6"));
////        System.out.println(controller.delete("9"));
//          List<Country> cs = controller.search("Ore");
////        List<Country> countrys = controller.binding();
//        for (Country country : cs) {
//            System.out.println("id: " + country.getId() + ", name: " + 
//                    country.getName() + ", region: " + country.getRegion());
//        }
//    }
//    get by id
        Country country = controller.getById("3");
        System.out.println(country.getId());
        System.out.println(country.getName());
        System.out.println(country.getRegion());
    }
}
