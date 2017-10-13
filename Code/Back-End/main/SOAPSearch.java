/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cos301.main;
import java.util.*;
import javax.xml.ws.WebServiceRef;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;
import javax.xml.transform.Result;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import cos301.datasource.Product;
import soap.ObjectArray;
import soap.Server;
import soap.ServerService;
/**
 *
 * @author Daniel
 */
public class SOAPSearch {
        ServerService service;
        Server server;
        

    public SOAPSearch()
    {
        service = new ServerService();
        server = service.getServerPort();
    }
        
    public List<Product> search(String productName)
    {
        List<Product> list = new ArrayList<>();
        try {
            List<ObjectArray> resultList = server.runDiagram2("pharma.plz/query1", productName, 1, 100, null);
                for (ObjectArray o: resultList){
                    list.add(new Product(o));
                }            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            //System.out.println(ex);
        }
        
        return list;
    }
    
    public Product searchById(int id)
    {
        Product product = null;
        try {
            List<ObjectArray> o = server.runDiagram2("pharma.plz/query2", ""+id, 1, 100, null);
            if (o.size()> 0){
                product = new Product(o.get(0));
                product.convertToProduct(o.get(0));
                System.out.println(o.get(0).getContents());
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            //System.out.println(ex);
        }
        return product;
    }    
}
