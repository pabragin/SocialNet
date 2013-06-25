/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

/**
 *
 * @author Brasha
 */
import business.User;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


 
public class ReadXML {
    
    public class LengthCity {
        public String fName;
        public String sName;
        public int length;
        
        public LengthCity(String fName, String sName, int length) {
            this.fName=fName;
            this.sName=sName;
            this.length=length;
        }
    }
    private static ArrayList<LengthCity> LC=new ArrayList<>();
    
    public boolean lengthExist(User current, User view)
    {
        ArrayList<LengthCity> LL= new ArrayList<>();
        LL = new ReadXML().getAllLength();
        boolean find=false;
        int i=0;
        System.out.println(LL.size());
        for(i=0; i<LL.size(); i++)
        {
            
            System.out.println(LL.get(i).fName+" "+(current.getCity()) + " "+ LL.get(i).sName+" "+(view.getCity()));
            if((LL.get(i).fName == null ? (current.getCity()) == null : LL.get(i).fName.equals(current.getCity())) && (LL.get(i).sName == null ? (view.getCity()) == null : LL.get(i).sName.equals(view.getCity())))
            {
                find=true;
                break;
            }
        }
        return find;
    }
    
    public String getLength(User current, User view)
    {
        ArrayList<LengthCity> LL= new ArrayList<>();
        LL = new ReadXML().getAllLength();
        boolean find=false;
        int i=0;
        System.out.println(LL.size());
        for(i=0; i<LL.size(); i++)
        {
            
            System.out.println(LL.get(i).fName+" "+(current.getCity()) + " "+ LL.get(i).sName+" "+(view.getCity()));
            if((LL.get(i).fName == null ? (current.getCity()) == null : LL.get(i).fName.equals(current.getCity())) && (LL.get(i).sName == null ? (view.getCity()) == null : LL.get(i).sName.equals(view.getCity())))
            {
                find=true;
                break;
            }
        }
        if(find)
        {
            return String.valueOf(LL.get(i).length);
        }
        else
            return null;
    }
 
    public ArrayList<LengthCity> getAllLength() {
 
    try {
 
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
 
	DefaultHandler handler = new DefaultHandler() {
 
	boolean bfname = false;
	boolean bsname = false;
	boolean blength = false;
        
        String fName=null;
        String sName=null;
        int len=0;
 
	public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {
 
		if (qName.equalsIgnoreCase("FIRSTCITY")) {
			bfname = true;
		}
 
		if (qName.equalsIgnoreCase("SECONDCITY")) {
			bsname = true;
		}
 
		if (qName.equalsIgnoreCase("LENGTH")) {
			blength = true;
		}
 
	}
 
	public void endElement(String uri, String localName,
		String qName) throws SAXException {
 
 
	}
 
	public void characters(char ch[], int start, int length) throws SAXException {
            
 
		if (bfname) {
                        fName=new String(ch, start, length);
			bfname = false;
		}
 
		if (bsname) {
                        sName=new String(ch, start, length);
			bsname = false;
		}
 
		if (blength) {
                        len = Integer.parseInt(new String(ch, start, length));
			blength = false;
		}
                if(fName!=null && sName!=null && len!=0)
                {
                    LC.add(new LengthCity(fName, sName, len));
                }
	}
 
     };
 
       saxParser.parse("C:\\OTHER\\Study\\5th\\2-sem\\TRP\\SocialNet\\Service.xml", handler);
       return LC;
 
     } catch (Exception e) {
       e.printStackTrace();
     }
    return LC;
   }
 
}
