
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOM_Adatmodositas_LHS2S6 {

	public static void main(String[] args) {

		// A m�sodik nagyd�j elmaradt, ez�rt az adatait friss�teni kell �j helysz�nre �s
		// id�pontra

		try {
			// Az XML f�jl beolvas�sa:
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmlfile = db.parse(new File("C:\\Users\\poczo\\Desktop\\xml beadando\\f1.xml"));

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

					if (curElement.getTagName() == "nagydij") {

						// Egy �jabb node ba lek�rj�k az aktu�lis elem gyerekelemeit:
						Node cur = curElement.getFirstChild();

						// Ciklus ami addig megy am�g tal�l a cur node-dal egy szinten l�v� (testv�r)
						// node-okat:
						while (cur != null) {
							// ha az akt�lis node ism�t elem akkor elemm� alak�tjuk:
							if (cur.getNodeType() == Node.ELEMENT_NODE) {
								Element current = (Element) cur;
								// vizsg�ljuk a fent megadott felt�telt majd m�dos�tjuk az adatokat
								if (current.getTagName() == "id" && Integer.parseInt(current.getTextContent()) == 2) {
									cur = cur.getNextSibling();
									cur = cur.getNextSibling();
									cur.setTextContent("Olasz nagyd�j");
									cur = cur.getNextSibling();
									cur = cur.getNextSibling();
									cur.setTextContent("2019-04-07");

								}
							}
							// a k�vetkez� testv�r node lek�r�se, ha nincs akk null-t ad �s a ciklus kil�p
							cur = cur.getNextSibling();
						}

					}
				}
			}

			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			DOMSource ds = new DOMSource(xmlfile);
			StreamResult sr = new StreamResult(new File("C:\\Users\\poczo\\Desktop\\xml beadando\\f1out.xml"));
			tf.transform(ds, sr);

			System.out.println("M�dos�t�s sikeres. A m�dos�tott xml f�jl mentve az f1out.xml f�jlba");

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
