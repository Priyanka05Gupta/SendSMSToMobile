package com.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

/**
 * 
 * @author Priyanka Gupta
 * @date 1st May 2020
 * @LearnedFrom https://www.youtube.com/watch?v=xl-5fd6ZSAA
 * It sends the SMS to mobile from this Java Code 
 * 
 */
public class SendSMSToMobile {
	
	public static void main(String[] args) {
		System.out.println("Message sending program started!");
		SendSMSToMobile.sendSms("This message is send from IdeaPad S145 by Priyanka Gupta "+ new Date().toLocaleString(), "7905404476");
	}
	
	public static void sendSms(String message, String mobileNo) {
		try {
			String apiKey="OTJlUjs7vwcZ3eViWxy45aLMXdugIqPREzND8f9tkbr2Y6BpCAXlSGFjuZdcxmNgQBeAT4CJUI50vzWb";
			String sender_id="FSTSMS";
			message= URLEncoder.encode(message, "UTF-8");
			System.out.println(message);
			String language="english";
			String route="p";

			String myURL= "https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sender_id+"&message="+message+"&language="+language+"&route="+route+"&numbers="+mobileNo;
			System.out.println(myURL);
			URL url = new URL(myURL); 
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("cache-control", "no-cache");
			int code= con.getResponseCode();
			System.out.println("REsponse Code :"+ code);
			StringBuffer response = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				response.append(line);
			}
			System.out.println(response);
			}catch (Exception e) {
				e.printStackTrace();	
			}	
	}
}
