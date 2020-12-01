import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class XsdValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b;
		
		try{
            File xsd = new File("D:\\!Gyakorlatok\\XMLGyak\\Lhs2s6_10_22\\cats.xsd");
            System.out.println(xsd.getCanonicalPath());
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource("D:\\!Gyakorlatok\\XMLGyak\\Lhs2s6_10_22\\cats.xsd"));

            System.out.println(schema.toString());
            Validator validator  = schema.newValidator();
            validator.validate(new StreamSource(new File("D:\\!Gyakorlatok\\XMLGyak\\Lhs2s6_10_22\\cats.xml")));
            b=true;
        }catch(Exception exe){
            exe.printStackTrace();
        b=false;
        }
		if (b) {
			System.out.println("XSD Validation successful.");
		}

	}

}
