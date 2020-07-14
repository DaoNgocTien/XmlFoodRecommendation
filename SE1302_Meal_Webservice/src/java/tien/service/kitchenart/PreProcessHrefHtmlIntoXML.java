/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.service.kitchenart;

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
public class PreProcessHrefHtmlIntoXML {

    private static String URL = "http://cook.kitchenart.vn/cong-thuc-nau-an/page/";

    public static String preProcessHrefHtmlIntoXML() throws MalformedURLException, IOException {

        String content = "";
        content += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n";
        content += "<div class=\"congthuc_item\">" + "\n";

        for (int i = 1; i < 32; i++) {

            URL url = new URL(URL + i + "/");
            URLConnection urlConnection = url.openConnection();

            String line = "";
            String begin = "<div class=\"congthuc_item\">";
            String beginWriting = "<a href=\"http://cook.kitchenart.vn/cong-thuc-nau-an/";
            String end = "<!-- chỉ mục trang -->";
            boolean start = false;

            try (InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
                    BufferedReader br = new BufferedReader(isr)) {
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    
                    //  kiểm tra khi nào bắt đầu ghi line
                    if (line.contains(begin)) {
                        start = true;
                    } else if (line.contains(end)) {
                        break;
                    }

                    //  ghi line
                    if (start && !line.contains("<h3>") && line.contains(beginWriting)) {
                        line = line.replace("><img", "");
                        line = line.replace("/></a>", "></a>");
                        line = line.replace("\"chiên\"", "chiên");
                        line = line.replace("&", " and ");
                        content += line + "\n";
                    }

                }
            }
        }

        content += "</div>" + "\n";
        return content;
    }
}
