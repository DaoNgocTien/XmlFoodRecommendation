/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.jaxb;

import com.sun.codemodel.JCodeModel;
import com.sun.tools.xjc.api.ErrorListener;
import com.sun.tools.xjc.api.S2JJAXBModel;
import com.sun.tools.xjc.api.XJC;
import com.sun.tools.xjc.api.SchemaCompiler;
import java.io.File;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;
import tien.utils.Constants;

/**
 *
 * @author Admin
 */
public class XJCGenerateJavaObject {

    private static final Constants CONSTANTS = new Constants();
    private static final String OUTPUT = CONSTANTS.XJC_OUTPUT;

    public static void generateJavaObject(File schemaFile) throws IOException {
        SchemaCompiler sc = XJC.createSchemaCompiler();
        sc.setErrorListener(new ErrorListener() {
            @Override
            public void error(SAXParseException saxpe) {
                System.out.println("Error:  " + saxpe);
            }

            @Override
            public void fatalError(SAXParseException saxpe) {
                System.out.println("Fatal Error:  " + saxpe);
            }

            @Override
            public void warning(SAXParseException saxpe) {
                System.out.println("Warning:  " + saxpe);
            }

            @Override
            public void info(SAXParseException saxpe) {
                System.out.println("Info:  " + saxpe);
            }
        });

        sc.forcePackageName("tien.jaxb.obj");
        InputSource is = new InputSource(schemaFile.toURI().toString());
        sc.parseSchema(is);

        S2JJAXBModel model = sc.bind();
        JCodeModel code = model.generateCode(null, null);
        code.build(new File(OUTPUT));

        System.out.println("generateJavaObject successfully");
    }
}
