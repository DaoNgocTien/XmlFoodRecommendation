/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.utils;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Constants implements Serializable {

    public final String MATERIAL_SCHEMA_FILE = "/WEB-INF/material.xsd";
    public final String MATERIAL_RAW_MATERIAL = "/WEB-INF/rawMaterial.xml";
    public final String MATERIAL_XSL_FILE = "/WEB-INF/material.xsl";
    public final String MATERIAL_VALIDATED_XML = "/WEB-INF/validatedXML.xml";
    public final String MATERIAL_REAL = "D:\\DaoNgocTien\\SE1302_Meal_Webservice\\web";

    public final String MATERIAL_CRAWL_URL = "https://thehinh365.com/cong-cu/thanh-phan-dinh-duong-cac-loai-thuc-pham/";
    public final String MATERIAL_CONTENT_BEGIN = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" + "<tbody>" + "\n";
    public final String MATERIAL_CONTENT_END = "</tbody>" + "\n";
    public final String MATERIAL_BEGIN = "<tbody>";
    public final String MATERIAL_END = "</tbody>";
    public final int MATERIAL_BEGINWRITING = 12;
    public final int MATERIAL_BEGINWRITING_ANIMAL = 20;

    public final String XJC_OUTPUT = "D:\\DaoNgocTien\\SE1302_Meal_Webservice\\src\\java";

    public final String STRING_SIMILARITY_DEMO = "https://www.tools4noobs.com/?action=ajax_string_similarity&text=&text2=&limit=0.4";
    public final String STRING_SIMILARITY_ADD_REQUEST_PROPERTY_AGENT = "User-Agent";
    public final String STRING_SIMILARITY_ADD_REQUEST_PROPERTY_BROWSER = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0";

    public final String FOOD_RAW_FOOD = "/WEB-INF/rawFood.xml";
    public final String FOOD_CRAWL_URL = "http://cook.kitchenart.vn/cong-thuc-nau-an/page/";
    public final String FOOD_CONTENT_END = "</div>" + "\n";
    public final String FOOD_BEGIN = "<div class=\"congthuc_item\">";
    public final String FOOD_END = "<!-- chỉ mục trang -->";
    public final String FOOD_BEGINWRITING = "<a href=\"http://cook.kitchenart.vn/cong-thuc-nau-an/";

//    FOOD HREF CRAWLING SAMPLE
//    line = line.replace("><img", "");
//    line = line.replace("/></a>", "></a>");
//    line = line.replace("\"chiên\"", "chiên");
//    line = line.replace("&", " and ");
    



    public final String FOOD_DETAIL_BEGIN = "<div class=\"nguyen_lieu\">";
    public final String FOOD_DETAIL_BEGIN_TOOL = "<div class=\"nguyen_lieu dung_cu\">";
    public final String FOOD_DETAIL_BEGIN_COOKING_METHOD = "cach_che_bien";
    public final String FOOD_DETAIL_END = "<div style=\"margin: 20px 0; padding: 10px; border: 1px ";
    public final String FOOD_DETAIL_CHECK_MATERIAL_CONTAINS = "<span class=\"btn_muahang\">";
    public final String FOOD_DETAIL_CHECK_MATERIAL_REPLACE_WITH_EMPTY = "<li><span class=\"btn_muahang\"><i class=\"fa fa-circle\" aria-hidden=\"true\"></i>";
    public final String FOOD_DETAIL_CHECK_MATERIAL_REPLACE_WITH_EMPTY_A = "<a";

    public Constants() {
    }

}
