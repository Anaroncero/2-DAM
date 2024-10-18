package ejemploProf;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class parserDOM {
    
    public static void main(String[] args) {

        
        try {
            // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Configurar la factoria para que el fichero que se carga está bien validado e ignora espacios en blanco.
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            // Se crea un objeto DocumentBuilder por medio de la factoría creada previamente.
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Especificar el archivo XML que deseas analizar.
            File file = new File("prueba.xml");

            // Parsear (analizar) el archivo XML y obtener un objeto Document.
            Document doc = builder.parse(file);
            //Omite por ejemplo los saltos de linea
            //doc.getDocumentElement().normalize();

            //Crear un objeto XPath para consultar el documento XML.
            XPath xPath = XPathFactory.newInstance().newXPath();
            //Definir la expresión XPath para obtener todas las bibliotecas.
            String expression = "/libraries/library";
            //Evaluar la expresión XPath y obtener una lista de nodos de bibliotecas.
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            // Iterar a través de la lista de nodos de bibliotecas.
            for(int i=0;i<nodeList.getLength();i++){
                Node nNode = nodeList.item(i);
                System.out.println("\nElement Actual:" + nNode.getNodeName());
                //System.out.println("\nElement Padre:" + nNode.getParentNode());

                if(nNode.getNodeType()== Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    System.out.println("Nombre :" +eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Ciudad :" +eElement.getAttribute("location"));
                    System.out.println("");

                  // Definir la expresión XPath para obtener los libros de la biblioteca actual.
                    String bookExpression = "books/book";
                    
                    // Evaluar la expresión XPath y obtener una lista de nodos de libros para esta biblioteca.
                    NodeList bookNodeList = (NodeList) xPath.compile(bookExpression).evaluate(nNode, XPathConstants.NODESET);
                    
                    // Iterar a través de la lista de nodos de libros y mostrar la información de cada libro.
                    for (int j = 0; j < bookNodeList.getLength(); j++) {
                        Node bookNode = bookNodeList.item(j);
                        if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element bookElement = (Element) bookNode;
                            System.out.println("Título del Libro: " + bookElement.getElementsByTagName("title").item(0).getTextContent());
                            System.out.println("Autor del Libro: " + bookElement.getElementsByTagName("author").item(0).getTextContent());
                            System.out.println("Género del Libro: " + bookElement.getElementsByTagName("genre").item(0).getTextContent());
                            System.out.println("Año del Libro: " + bookElement.getElementsByTagName("year").item(0).getTextContent());
                            System.out.println("-----"); // Separador entre libros
                        }
                    }
                    System.out.println("=========="); // Separador entre bibliotecas
                }
            }          
        
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }      
        
    }
}
