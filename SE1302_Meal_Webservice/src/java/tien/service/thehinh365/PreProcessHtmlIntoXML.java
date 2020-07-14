/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.service.thehinh365;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Admin
 */
public class PreProcessHtmlIntoXML {

    private static final String URL = "https://thehinh365.com/cong-cu/thanh-phan-dinh-duong-cac-loai-thuc-pham/";
    private static final String KITCHENURL = "http://cook.kitchenart.vn/cong-thuc-nau-an/";
    private static final String WIKI = "https://wikithethao.com/luong-calo-trong-thuc-an/";

    public static String preProcessHtmlIntoXML() throws MalformedURLException, IOException {

        String content = "";
        content += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n";
        content += "<tbody>" + "\n";

        URL url = new URL(URL);
        URLConnection urlConnection = url.openConnection();

        String line = "";
        String begin = "<tbody>";
        String end = "</tbody>";
        boolean start = false;
        boolean startTableAnimal = false;
        int beginWriting = 12;

        try (InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(isr)) {
            while ((line = br.readLine()) != null) {
                line = line.trim();
                line = line.replace("125,170.00", "125.170");
                //  kiểm tra khi nào bắt đầu ghi line
                if (line.contains(begin)) {
                    start = true;
                } else if (line.contains(end)) {
                    //  startTableAnimal == false là chưa bắt đầu table animal
                    if (!startTableAnimal) {
                        start = false;
                        startTableAnimal = true;
                        beginWriting = 20;
                    } else {
                        break;
                    }
                }

                //  ghi line
                if (start) {
                    if (beginWriting == 0) {
                        content += line + "\n";
                    } else {
                        beginWriting--;
                    }
                }

            }
        }

        content += "</tbody>" + "\n";
        return content;
    }

//    public static String preProcessHtmlIntoXMLWITHWIKI() throws MalformedURLException, IOException {
//
//        String content = "";
//        content += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n";
//        content += "<tbody>" + "\n";
//
//        URL url = new URL(WIKI);
//        URLConnection urlConnection = url.openConnection();
//
//        String line = "";
//        String begin = "<p>Các thông số đều được tính trong 100 Gram thực phẩm.</p>";
//        String end = "</tbody>";
//        boolean start = false;
//        int beginWriting = 12;
//
//        try (InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8);
//                BufferedReader br = new BufferedReader(isr)) {
//            while ((line = br.readLine()) != null) {
//                line = line.trim();
//                line = line.replace("125,170.00", "");
//                //  kiểm tra khi nào bắt đầu ghi line
//                if (line.contains(begin)) {
//                    start = true;
//                } else if (line.contains(end)) {
//
//                    break;
//
//                }
//
//                //  ghi line
//                if (start) {
//                    if (beginWriting == 0) {
//                        content += line + "\n";
//                    } else {
//                        beginWriting--;
//                    }
//                }
//
//            }
//        }
//
//        content += "</tbody>" + "\n";
//        return content;
//    }
}
