
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParserLhs2s6 {

	public static void main(String[] args) {
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("D:\\!Gyakorlatok\\XMLGyak\\lhs2s6_11_05\\student.xml"));

			document.getDocumentElement().normalize();
			System.out.println("Root element : "+document.getDocumentElement().getNodeName());
			NodeList list =document.getElementsByTagName("student");
			System.out.println("----------------");
			
			for(int i=0; i<list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element. "+node.getNodeName());
				
				if (node.getNodeType()==Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Student roll no: "+element.getAttribute("rollno"));
					
					System.out.println("First name: "+element.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last name: "+element.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nickname: "+element.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Age: "+element.getElementsByTagName("age").item(0).getTextContent());
				}
				
			}
			

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
