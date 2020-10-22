import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
public class SaxLHS2S6 {
	
	public static void main(String[] args) throws Exception{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			parser.parse(new File("D:\\!Gyakorlatok\\XMLGyak\\Lhs2s6_10_22\\cats.xml"),handler);
			
			List<Cats> cats = handler.getCatslist();
			System.out.println("cats start");
			for(int i=0; i<cats.size(); i++) {
				System.out.println("	cat, {id:"+cats.get(i).getId()+"} start");
				System.out.println("		name start");
				System.out.println("			"+cats.get(i).getName());
				System.out.println("		name end");
				System.out.println("		age start");
				System.out.println("			"+cats.get(i).getAge());
				System.out.println("		age end");
				System.out.println("		breed start");
				System.out.println("			"+cats.get(i).getBreed());
				System.out.println("		breed end");
				System.out.println("	cat, {id:"+cats.get(i).getId()+"} end");
			}
			System.out.println("cats end");
		} catch (ParserConfigurationException | SAXException | IOException e) {
	        e.printStackTrace();
	    }
		
		
		
		
	}
	

}
