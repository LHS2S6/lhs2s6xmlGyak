
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

			// Az XML dokumentum gy�k�relem�nek lek�rdez�se �s kiirat�sa:
			Element gyokerelem = xmlfile.getDocumentElement();
			System.out.println("Az XML dokumentum gy�k�releme: " + gyokerelem.getNodeName());

			// A gyerekelemek megkeres�se majd NodeList-be rak�sa:
			NodeList gyerekelemek = gyokerelem.getChildNodes();

			// A gyerekelemek lista feldolgoz�sa:
			for (int i = 0; i < gyerekelemek.getLength(); i++) {

				// Aktu�lis node lek�r�se:
				Node curNode = gyerekelemek.item(i);

				// Az aktu�lis node elemvizsg�lata:
				if (curNode.getNodeType() == Node.ELEMENT_NODE) {

					// Az aktu�lis node elemm� alak�t�sa:
					Element curElement = (Element) curNode;

					// Kiirat�s:
					System.out.println("Aktu�lis elem: " + curElement.getTagName());

					// Egy �jabb node ba lek�rj�k az aktu�lis elem gyerekelemeit:
					Node cur = curElement.getFirstChild();

					// Ciklus ami addig megy am�g tal�l a cur node-dal egy szinten l�v� (testv�r)
					// node-okat:
					while (cur != null) {
						// ha az akt�lis node ism�t elem akkor elemm� alak�tjuk:
						if (cur.getNodeType() == Node.ELEMENT_NODE) {
							Element current = (Element) cur;
							// Majd kiiratjuk az elem nev�t �s a tartalm�t:
							System.out.println("  " + current.getTagName() + ":  " + current.getTextContent());
						}
						// a k�vetkez� testv�r node lek�r�se, ha nincs akk null-t ad �s a ciklus kil�p
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

	