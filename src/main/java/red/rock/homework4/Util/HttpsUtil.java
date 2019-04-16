package red.rock.homework4.Util;






import org.apache.http.HttpConnection;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 *
 *  Https工具类
 * @author  tudou
 * @date 2019/4/16 17:15
 * @version 1.0
 **/
public class HttpsUtil {

        /**
             * 以https方式发送请求并将请求响应内容以String方式返回
             * @param path 请求路径
             * @param method 请求方法
             * @param body 请求数据体
             * @return  请求响应内容转换成字符串信息
             */
        public static String httpsRequestToString(String path,String method,String body){

            if(path==null||method==null){
                return null;
            }

            String response=null;
            InputStream inputStream=null;
            InputStreamReader inputStreamReader=null;
            BufferedReader bufferedReader=null;
            HttpsURLConnection connection=null;

            try{
                //创建SSLContext对象,并使我们指定的信任管理器初始化
                TrustManager[] tm={new JEEWeiXinX509TrustManager()};
                SSLContext sslContext=SSLContext.getInstance("SSL","SunJSSE");
                sslContext.init(null,tm,new java.security.SecureRandom());

                //从上述对象中的到SSLSocketFactory
                SSLSocketFactory ssf=sslContext.getSocketFactory();

                System.out.printf(path);

                URL url=new URL(path);
                connection=(HttpsURLConnection)url.openConnection();
                connection.setSSLSocketFactory(ssf);
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setUseCaches(false);

                //设置请求方式
                connection.setRequestMethod(method);

                //有数据提交时
                if(null!=body){
                    OutputStream outputStream=connection.getOutputStream();
                    outputStream.write(body.getBytes("UTF-8"));
                    outputStream.close();
                }

                //将返回的输入流转换成字符串
                inputStream=connection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
                bufferedReader=new BufferedReader(inputStreamReader);
                String str=null;
                StringBuffer buffer=new StringBuffer();
                while((str=bufferedReader.readLine())!=null){
                    buffer.append(str);
                }

                response=buffer.toString();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(connection!=null){
                    connection.disconnect();
                }
                try{
                    bufferedReader.close();
                    inputStreamReader.close();
                    inputStream.close();
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
            return response;
        }

}
