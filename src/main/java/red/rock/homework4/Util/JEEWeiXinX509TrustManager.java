package red.rock.homework4.Util;

import javax.net.ssl.X509TrustManager;

import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/16 17:26
 **/
public class JEEWeiXinX509TrustManager implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)throws CertificateEncodingException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

}
