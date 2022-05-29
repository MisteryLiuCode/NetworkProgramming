import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyTest {
    public static void main(String[] args) throws UnknownHostException {
        MyTest myTest = new MyTest();
//        获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("主机localHost:"+localHost);
//        根据指定主机名获取InetAddress对象
        InetAddress localhost2 = InetAddress.getByName("bogon");
        System.out.println("根据主机名获取localhost"+localhost2);
//        根据域名返回InetAddress对象，比如我的博客域名www.misteryliu.top
        InetAddress host3 = InetAddress.getByName("www.misteryliu.top");
        System.out.println("根据域名获取主机ip"+host3);
//        通过hostAddress对象获取host地址
        String address = host3.getHostAddress();
        System.out.println("通过hostAddress对象获取ip地址"+address);
//        通过InetAddress对象，获取对应的主机名，或者域名
        String hostName = host3.getHostName();
        System.out.println("通过InetAddress对象，获取对应的主机名，或者域名:"+hostName);
    }
}
