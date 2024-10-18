import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;


public class playlistManejoErrores {

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

            // XPath
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            String expression = "/playlist/cancion/titulo";
            // Guardar en la lista el titulo de todas las canciones
            NodeList listaNodos = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
            
            // Mostrar toda la lista
            for (int i = 0; i < listaNodos.getLength(); i++) {
                System.out.println((i + 1) + ". " + 
                listaNodos.item(i).getTextContent());
            }

        } catch (ParserConfigurationException e) {
            System.err.println("Error de configuración del analizador XML: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de lectura del archivo XML: " + e.getMessage());
        } catch (XPathExpressionException e) {
            System.err.println("Error en la expresión XPath: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println("Error SAX durante el análisis XML: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }

    }
}