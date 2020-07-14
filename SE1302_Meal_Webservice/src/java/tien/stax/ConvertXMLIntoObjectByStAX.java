/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.stax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import tien.utils.StAXUtils;
import tien.webservice.Food;

/**
 *
 * @author Admin
 */
public class ConvertXMLIntoObjectByStAX {

    public List<Food> convertXMLFoodIntoObjectByStAX(File xmlFile) throws FileNotFoundException, XMLStreamException {
        List<Food> list = new ArrayList<>();
        Food food = null;
        String content = "";

        XMLStreamReader reader = StAXUtils.getStAXStreamReader(xmlFile);
        //  XML ví dụ
        //      <a href="h" title="t" src="s">
        //          <b>222</b>
        //          <c>333</c>
        //      </a>

        //  duyet cac phan tu
        while (reader.hasNext()) {
            int event = reader.next();
            //  Bắt đầu duyệt từng đối tượng
            switch (event) {
                //  Nếu thẻ mở là: 
                case XMLStreamConstants.START_ELEMENT:
                    //  <a>: lấy thẻ a
                    if ("a".equalsIgnoreCase(reader.getLocalName())) {
                        food = new Food();
                        //  Lấy từng thuộc tính một
                        food.setHref(reader.getAttributeValue("", "href"));
                        food.setTitle(reader.getAttributeValue("", "title"));
                        food.setImage(reader.getAttributeValue("", "src"));
                    }
                    break;

                //  Đọc nội dung thẻ hiện tại
                case XMLStreamConstants.CHARACTERS:
                    content = reader.getText().trim();
                    break;

                //  Đọc thẻ kết thúc
                case XMLStreamConstants.END_ELEMENT:
                    //  Đọc tên thẻ kết thúc
                    switch (reader.getLocalName()) {
                        case "a":
                            //  content hiện tại là ""
                            list.add(food);
                            break;
                        case "b":
                            //  content hiện tại là "222"
                            break;
                        case "c":
                            //  content hiện tại là "333"
                            break;
                    }
                    break;
            }
        }
//        System.out.println(list.size());
        System.out.println("convertXMLFoodIntoObjectByStAX successfully");
//        for (Food item : list) {
//            System.out.println("tien.webservice.Food[ href=" + item.getHref() + " ][ img=" + item.getImage()+ " ][ title=" + item.getTitle()+ " ]");
//        }
        return list;
    }
}
