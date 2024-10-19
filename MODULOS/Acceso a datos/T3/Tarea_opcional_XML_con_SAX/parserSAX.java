import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ejemploProf.XPathEjemploSAX.SAXHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/* DOM Y SAX: Son herramientas que nos ofrecen la posibilidad de leer ficheros XML. Estas 
herramientas se dedican a verificar si sintácticamente son ficheros válidos. Son los llamados “parsers” 
o analizadores. En este ejemplo se puede ver también como podemos hacer consultas xon XPath */

public class parserSAX {
    public static void main(String[] args) {
        try {

            // Configura la fábrica del analizador SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // Crea una instancia del analizador SAX
            SAXParser saxParser = factory.newSAXParser();
            // Crea un manejador personalizado
            SAXHandler handler = new SAXHandler();
            // Analiza el archivo XML con el manejador
            saxParser.parse(new File("T3\\Tarea_opcional_XML_con_SAX\\playlist.xml"), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Clase interna que actúa como un manejador personalizado para eventos SAX
    public static class SAXHandler extends DefaultHandler {
        // Controla si estamos dentro de un elemento 'playlist'
        private boolean inPlaylist = false;
        // Controla si estamos dentro de un elemento 'cancion'
        private boolean inCancion = false;
        // Almacena el nombre del elemento actual
        private String currentElement;

       
        /*El método startElement se llama cuando el analizador encuentra un elemento de apertura en el documento XML. En este método, se almacena el nombre del elemento actual en la variable currentElement. */
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
             // Guarda el nombre del elemento actual
            currentElement = qName;
            // Indica que estamos dentro de un elemento se cambia a true
            if ("playlist".equals(qName)) {
                inPlaylist = true;
                System.out.println("\nElemento Actual: " + qName);
                
            } else if ("cancion".equals(qName)) {
                inCancion = true;
                System.out.println("-----");
            }
        }

        /* El método characters se llama cuando el analizador encuentra el contenido dentro de un elemento. 
        En este método, se obtiene el valor del contenido y se imprime. */
        public void characters(char[] ch, int start, int length) throws SAXException {
            String value = new String(ch, start, length).trim();
            // Imprime el contenido del elemento
            if (!value.isEmpty()) {
                System.out.println(currentElement + ": " + value);
            }
        }

        /*El método endElement se llama cuando el analizador encuentra un elemento de cierre en el documento XML.
        En este método, se indica que se ha salido del elemento actual. */
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Indica que hemos salido del elemento
            if ("library".equals(qName)) {
                inPlaylist = false;
                System.out.println("==========");
                
            } else if ("book".equals(qName)) {
                inCancion = false;
            }
        }
    }
}