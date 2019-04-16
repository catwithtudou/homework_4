package red.rock.homework4.Util;

import java.nio.Buffer;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 *
 * 请求校验工具
 * @author  tudou
 * @date 2019/4/15 18:37
 * @version  1.0
 **/
public class CheckUtil {

    private static final String TOKEN="zhengyu";

    public static boolean checkSignature(String signature,String timestamp,String nonce){
        String[] str=new String[]{TOKEN,timestamp,nonce};
        Arrays.sort(str);
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<str.length;i++){
            buffer.append(str[i]);
        }

        String temp=encode(buffer.toString());
        return signature.equals(temp);

    }

    private static  final char[] HEX_DIGITS={'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String getFormattedText(byte[] bytes){
        int len=bytes.length;
        StringBuilder buf=new StringBuilder(len*2);
        for(int j=0;j<len;j++){
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j]& 0x0f]);
        }
        return buf.toString();
    }

    public static String encode(String str){
        if(str==null){
            return null;
        }
        try{
            MessageDigest messageDigest=MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
