
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

		// A második nagydíj elmaradt, ezért az adatait frissíteni kell új helyszínre és
		// idõpontra

		try {
			// Az XML fájl beolvasása:
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmlfile = db.parse(new File("C:\\Users\\poczo\\Desktop\\xml beadando\\f1.xml"));

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

					if (curElement.getTagName() == "nagydij") {

						// Egy újabb node ba lekérjük az aktuális elem gyerekelemeit:
						Node cur = curElement.getFirstChild();

						// Ciklus ami addig megy amíg talál a cur node-dal egy szinten lévõ (testvér)
						// node-okat:
						while (cur != null) {
							// ha az aktális node ismét elem akkor elemmé alakítjuk:
							if (cur.getNodeType() == Node.ELEMENT_NODE) {
								Element current = (Element) cur;
								// vizsgáljuk a fent megadott feltételt majd módosítjuk az adatokat
								if (current.getTagName() == "id" && Integer.parseInt(current.getTextContent()) == 2) {
									cur = cur.getNextSibling();
									cur = cur.getNextSibling();
									cur.setTextContent("Olasz nagydíj");
									cur = cur.getNextSibling();
									cur = cur.getNextSibling();
									cur.setTextContent("2019-04-07");

								}
							}
							// a következõ testvér node lekérése, ha nincs akk null-t ad és a ciklus kilép
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

			System.out.println("Módosítás sikeres. A módosított xml fájl mentve az f1out.xml fájlba");

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
