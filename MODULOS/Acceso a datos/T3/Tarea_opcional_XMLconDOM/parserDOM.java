import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

/* DOM Y SAX: Son herramientas que nos ofrecen la posibilidad de leer ficheros XML. Estas 
herramientas se dedican a verificar si sintácticamente son ficheros válidos. Son los llamados “parsers” 
o analizadores. En este ejemplo se puede ver también como podemos hacer consultas xon XPath */

public class parserDOM {
    public static void main(String[] args) {
        try {
            // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            // Crear un objeto DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Ruta del XML que queremos analizar
            File file = new File("playlist.xml");

            // Parsear el XML y obtener un objeto Document
            Document doc = builder.parse(file);


            // Crear un objeto XPATH para consultar el documento XML
            XPath xPath = XPathFactory.newInstance().newXPath();
            // Definir la expresión XPath para obtener la lista de nodos
            String consulta = "/playlist/cancion";
            NodeList listaNodos = (NodeList) xPath.compile(consulta).evaluate(doc, XPathConstants.NODESET);

            // Iterar la lista
            for (int i = 0; i < listaNodos.getLength(); i++) {
                Node nNode = listaNodos.item(i);
                System.out.println("\nElemento Actual: " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Título: " + eElement.getElementsByTagName("titulo").item(0).getTextContent());

                    // Ahora accedemos al nombre del artista correctamente
                    Element artistaElement = (Element) eElement.getElementsByTagName("artista").item(0);
                    String nombreArtista = artistaElement.getElementsByTagName("nombre").item(0).getTextContent();
                    System.out.println("Artista: " + nombreArtista);

                    // Si necesitas la nacionalidad
                    String nacionalidadArtista = artistaElement.getElementsByTagName("nacionalidad").item(0)
                            .getTextContent();
                    System.out.println("Nacionalidad: " + nacionalidadArtista);

                    System.out.println("=========="); // Separador
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
