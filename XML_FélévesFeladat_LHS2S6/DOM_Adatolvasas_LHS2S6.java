
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOM_Adatolvasas_LHS2S6 {

	public static void main(String[] args) {
		try {
			// Az XML fajl beolvasasa:
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmlfile = db.parse(new File("C:\\Users\\poczo\\Desktop\\xml beadando\\f1.xml"));

			// Az XML dokumentum gyökérelemének lekérdezése és kiiratása:
			Element gyokerelem = xmlfile.getDocumentElement();
			System.out.println("Az XML dokumentum gyökéreleme: " + gyokerelem.getNodeName());

			// A gyerekelemek megkeresése majd NodeList-be rakása:
			NodeList gyerekelemek = gyokerelem.getChildNodes();

			// A gyerekelemek lista feldolgozása:
			for (int i = 0; i < gyerekelemek.getLength(); i++) {

				// Aktuális node lekérése:
				Node curNode = gyerekelemek.item(i);

				// Az aktuális node elemvizsgálata:
				if (curNode.getNodeType() == Node.ELEMENT_NODE) {

					// Az aktuális node elemmé alakítása:
					Element curElement = (Element) curNode;

					// Kiiratás:
					System.out.println("Aktuális elem: " + curElement.getTagName());

					// Egy újabb node ba lekérjük az aktuális elem gyerekelemeit:
					Node cur = curElement.getFirstChild();

					// Ciklus ami addig megy amíg talál a cur node-dal egy szinten lévõ (testvér)
					// node-okat:
					while (cur != null) {
						// ha az aktális node ismét elem akkor elemmé alakítjuk:
						if (cur.getNodeType() == Node.ELEMENT_NODE) {
							Element current = (Element) cur;
							// Majd kiiratjuk az elem nevét és a tartalmát:
							System.out.println("  " + current.getTagName() + ":  " + current.getTextContent());
						}
						// a következõ testvér node lekérése, ha nincs akk null-t ad és a ciklus kilép
						cur = cur.getNextSibling();
					}

					System.out.println();
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

	