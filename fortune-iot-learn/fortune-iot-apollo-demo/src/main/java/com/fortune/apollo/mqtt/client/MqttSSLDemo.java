package com.fortune.apollo.mqtt.client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class MqttSSLDemo {
	// https://blog.csdn.net/lingshi210/article/details/52439050

	// mqtt的命令和Java端的ssl 必须同时要带上ca.crt、clilent.crt、client.key三个文件，即CA证书、客户证书、客户私钥。
	// 由于java 端不支持client.key的格式，需要命令进行转化
	// openssl pkcs8 -topk8 -in client.key -out client.pem -nocrypt

	private SSLSocketFactory getSSLSocket(String caPath, String crtPath, String keyPath, String password)
			throws Exception {
		// CA certificate is used to authenticate server
		CertificateFactory cAf = CertificateFactory.getInstance("X.509");
		FileInputStream caIn = new FileInputStream(caPath);
		Certificate ca = cAf.generateCertificate(caIn);
		// https://blog.csdn.net/dotuian/article/details/51722300
		// 在keystore里，包含两种数据：
		// 1. 密钥实体（Key entity）——密钥（secret key）又或者是私钥和配对公钥（采用非对称加密）
		// 2. 可信任的证书实体（trusted certificate entries）——只包含公钥
		KeyStore caKs = KeyStore.getInstance("JKS");
		caKs.load(null, null);
		caKs.setCertificateEntry("ca-certificate", ca);
		TrustManagerFactory tmf = TrustManagerFactory.getInstance("PKIX");
		tmf.init(caKs);
		
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		FileInputStream crtIn = new FileInputStream(crtPath);
		Certificate caCert  = certificateFactory.generateCertificate(crtIn);		
		crtIn.close();
		
		// client key and certificates are sent to server so it can authenticate us 
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		 ks.load(null, null); ks.setCertificateEntry("certificate", caCert); 
		 ks.setKeyEntry("private-key", getPrivateKey(keyPath), password.toCharArray(), new java.security.cert.Certificate[]{caCert} ); 
		 KeyManagerFactory kmf = KeyManagerFactory.getInstance("PKIX"); kmf.init(ks, password.toCharArray());
		// finally, create SSL socket factory
		SSLContext context = SSLContext.getInstance("TLSv1");
		context.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new SecureRandom());
		return context.getSocketFactory();

	}
	
	public PrivateKey getPrivateKey(String path) throws Exception {
		String pem = getPem(path);
		byte[] encodedKey = Base64.getDecoder().decode(pem);
		
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedKey);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		
		return keyFactory.generatePrivate(keySpec);
	}
	
	private String getPem(String path) throws Exception{
        FileInputStream fin=new FileInputStream(path);
        BufferedReader br= new BufferedReader(new InputStreamReader(fin));  
        String readLine= null;  
        StringBuilder sb= new StringBuilder();  
        while((readLine= br.readLine())!=null){  
            if(readLine.charAt(0)=='-'){  
                continue;  
            }else{  
                sb.append(readLine);  
                sb.append('\r');  
            }  
        }  
        fin.close();
        return sb.toString();
    }

}
