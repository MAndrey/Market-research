package app;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * StockSupplies Tester.
 */
public class StockSuppliesTest {

  public static final Logger LOG = Logger.getLogger(StockSuppliesTest.class);

  @BeforeClass
  public static void setUp() throws Exception {
  

  }

   /**
   * Testing method: getName()
    *
    *  http://www.rts.ru/export/xml/indexvalues.aspx?code=RTSI
    *  простой тест на обращение к ресурсу.
    *
   */

  @Test
  public void testFsaf() throws Exception {
    //TODO: Test goes here...

      LOG.info("Testing for you");
      DefaultHttpClient client = new DefaultHttpClient();



      List qparams = new ArrayList();

      qparams.add(new BasicNameValuePair("code", "RTSI"));

      URI uri = URIUtils.createURI("http", "www.rts.ru", -1, "/export/xml/indexvalues.aspx", URLEncodedUtils.format(qparams, "UTF-8"), null);

      HttpUriRequest getRequest = new HttpGet(uri);
      getRequest.setHeader("User-Agent",  "xxxx");

      HttpResponse response = client.execute(getRequest);

      int statusCode = response.getStatusLine().getStatusCode();

      String content =null;

      if(statusCode==200){
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);
          //  System.out.println(content);
      }

      File f =null;
      f =  new File("C:\\output\\first.xml");
      if(!f.exists()){
          f.createNewFile();
      }

      FileOutputStream fileOutputStream = new FileOutputStream(f);
      if (content!=null){
         fileOutputStream.write(content.getBytes());
      };
      fileOutputStream.close();


      int chr=0;
      StringBuffer stringBuffer = new StringBuffer("");
      FileInputStream fileInputStream = new FileInputStream(f);

      while((chr = fileInputStream.read())!=-1){

            stringBuffer.append((char)chr);

      }

      System.out.println("fsadfasfasdfsafsafsafsaf");
      System.out.println("fsadfasfasdfsafsafsafsaf");
      System.out.println("fsadfasfasdfsafsafsafsaf");
      System.out.println(stringBuffer.toString());
      fileInputStream.close();



  }


}
