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
import tien.utils.Constants;

/**
 *
 * @author Admin
 */
public class PreProcessHrefHtmlIntoXML {
 private static final Constants CONSTANTS = new Constants();
    private static String URL = CONSTANTS.FOOD_CRAWL_URL;

    public static String preProcessHrefHtmlIntoXML() throws MalformedURLException, IOException {

        String content = "";
        content += CONSTANTS.MATERIAL_CONTENT_BEGIN;

        for (int i = 1; i < 32; i++) {

            URL url = new URL(URL + i + "/");
            URLConnection urlConnection = url.openConnection();

            String line = "";
            String begin = CONSTANTS.FOOD_BEGIN;
            String beginWriting = CONSTANTS.FOOD_BEGINWRITING;
            String end = CONSTANTS.FOOD_END;
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

        content += CONSTANTS.MATERIAL_CONTENT_END;
        return content;
    }
}
