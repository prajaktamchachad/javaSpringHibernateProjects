package XML_Parser;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*How to get XML Data in your Java Class
 Step 1: Get the Document Builder
 Step2: Get Document
 Step 3: Normalize the XML
 Step 4: Get XML tags
 */


public class XMLParser_CRUD {
	public static void main(String[] args) throws TransformerException {
		
	
	//Step 1: Get the Document Builder
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	
	try {
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//Step 2: Get the Document
		Document document = builder.parse(new File("../WorkDay/src/laptop.xml"));
		
		//Step 3:Normalize the XML
		document.getDocumentElement().normalize();
		
		//Step 4: Get the elements by tag name
		NodeList laptopList = document.getElementsByTagName("laptop");
		for(int i = 0 ; i < laptopList.getLength() ; i++)
		{
			Node laptop = laptopList.item(i);
			if(laptop.getNodeType() == Node.ELEMENT_NODE)
			{
				Element laptopElement = (Element) laptop;
				System.out.println("Laptop Name --- "+laptopElement.getAttribute("name"));
				
				//Also Get All the data of Child Nodes
				NodeList laptopDetails = laptop.getChildNodes();
				for(int j = 0 ; j < laptopDetails.getLength() ; j++)
				{
					Node detail = laptopDetails.item(j);
					if(detail.getNodeType() == Node.ELEMENT_NODE)
					{
						Element laptopDetail = (Element) detail;
						System.out.println("Laptop Details --- "+laptopDetail.getTagName() +" : "+laptopDetail.getAttribute("value"));
					}
					
				}
			}
		}
		
		System.out.println(laptopList);
		
		//Update a specific Attribute of a Laptop Node
		Node laptopNodeToUpdate = laptopList.item(0);
		if(laptopNodeToUpdate.getNodeType() == Node.ELEMENT_NODE)
		{
			Element laptopElement = (Element) laptopNodeToUpdate;
			laptopElement.setAttribute("name", "My New Laptop");
			System.out.println(laptopElement.getAttribute("name"));
		}
		
		//Remove a specif Laptop Node
		Node laptopNodeToDelete = laptopList.item(1);
		laptopNodeToDelete.getParentNode().removeChild(laptopNodeToDelete);
		
		//Write the Updated XML to XML File
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File("../WorkDay/src/laptop.xml"));
		transformer.transform(source, streamResult);
		
		
	}
	catch(ParserConfigurationException e)
	{
		e.printStackTrace();
	}
	catch(SAXException e)
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	}
}

