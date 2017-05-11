import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2017/5/11.
 */
public class IntelAdress {
    public static void main(String[] args) throws IOException {
        try
        {
            //使用InetAddress类的方法获取本地机的名称和IP地址。
            InetAddress loc=InetAddress.getLocalHost();
            System.out.println(loc);

            //使用InetAddress类的方法获取网站www.csdn.net的IP地址，如果存在多个IP地址，要求全部返回。
            InetAddress csdn[]=InetAddress.getAllByName("www.csdn.net");
            int n = csdn.length;
            System.out.println("www.csdn.net存在"+n+"个ip地址");
            for(int i=0;i<n;i++){
                System.out.println(csdn[i]);
            }

            //使用URL类下载深圳大学首页http://www.szu.edu.cn，并统计下载得到网页文件的大小。
            URL url=new URL("http://www.szu.edu.cn");
            URLConnection uc=url.openConnection();
            InputStream in=url.openStream();
            FileOutputStream out=new FileOutputStream(new File("index.html"));
            int a=0;
            while((a=in.read())!=-1) {out.write(a);}
            out.close();
            int size=uc.getContentLength();
            System.out.println("www.szu.edu.cn下载得到的网页文件大小:"+size+"B");
        }
        catch(UnknownHostException e)
        {
            System.out.println("error");
        }
    }
}
