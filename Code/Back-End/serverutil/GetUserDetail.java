package cos301.serverutil;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import cos301.datasource.UserDetailNew;

public class GetUserDetail {

	private UserDetailNew userdetailnew = null;

	// ==================================
	public UserDetailNew getLoginFromServer(final String pDeviceId, final String pAppName, final String pVersion,
			String pServerIp) {

		String SETUP_HTTP = "http://" + pServerIp + "/SmartServerPharma/";
		String http = SETUP_HTTP + "systemuser/" + pDeviceId + "/serverip/" + pServerIp + "/appname/" + pAppName
				+ "/version/" + pVersion;

		//http = "http://197.242.145.230:8080/SmartServerPharma/systemuser/7c64442a-b839-4079-8f27-53e9cc8db41a/serverip/197.242.145.230:8080/appname/SMARTREP/version/1.0";
		//http = "http://197.242.145.230:8080/SmartServerPharma/systemuser/CodeX_Project_University_Of_Pretoria/serverip/197.242.145.230:8080/appname/SMARTSEARCH/version/1.0";
		http = "http://197.242.145.230:8080/SmartServerPharma/systemuser/89b85798-cf29-4a31-ac2b-b4f2858e3fc8/serverip/197.242.145.230:8080/appname/SMARTREP/version/1.0";

        try {

        	URL url = new URL(http);
        	HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            if(conn.getResponseCode() == 200){

            	userdetailnew = new UserDetailNew();

	    		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    		DocumentBuilder db = dbf.newDocumentBuilder();
	    		Document doc = db.parse(url.openStream());

	            NodeList iduserdetail = doc.getElementsByTagName("IDUSERDETAIL");
	            NodeList usercode = doc.getElementsByTagName("USERCODE");
	            NodeList systemuser = doc.getElementsByTagName("SYSTEMUSER");
	            NodeList userstatus = doc.getElementsByTagName("USERSTATUS");
	            NodeList applicationserial = doc.getElementsByTagName("APPLICATIONSERIALNO");
	            NodeList username = doc.getElementsByTagName("USERNAME");
	            NodeList userpassword = doc.getElementsByTagName("USERPASSWORD");
	            NodeList servertype = doc.getElementsByTagName("SERVERTYPE");
	            NodeList useremail = doc.getElementsByTagName("USEREMAIL");
	            NodeList usertype = doc.getElementsByTagName("USERTYPE");

	            //System.out.println(list.item(0).getTextContent());

	        	userdetailnew.setIdUserDetail(iduserdetail.item(0).getTextContent());
	        	userdetailnew.setUserCode(usercode.item(0).getTextContent());
	        	userdetailnew.setSystemUser(systemuser.item(0).getTextContent());
	        	userdetailnew.setUserStatus(userstatus.item(0).getTextContent());
	        	userdetailnew.setApplicationSerialNo(applicationserial.item(0).getTextContent());
	        	userdetailnew.setUserName(username.item(0).getTextContent());
	        	userdetailnew.setUserPassword(userpassword.item(0).getTextContent());
	        	userdetailnew.setServerType(servertype.item(0).getTextContent());
	        	userdetailnew.setUserEmail(useremail.item(0).getTextContent());
	        	userdetailnew.setUserType(usertype.item(0).getTextContent());
            }

        } catch (ParserConfigurationException e) {
        } catch (SAXException e) {
        } catch (IOException e) {
        }
        return userdetailnew;
	}
}
