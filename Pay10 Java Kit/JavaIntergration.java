package com.pay.lean.bean;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.pay.util.ChecksumUtils;
 
public class PgResponselandingPage {

 public static int gen() {
     Random r = new Random( System.currentTimeMillis() );
     return 100000 + r.nextInt(200000);
 }
 
 public static void main(String[] args) throws NoSuchAlgorithmException {
	  Map<String, String> map = new HashMap<String, String>();
	  map.put("AMOUNT", "100");
	  map.put("CURRENCY_CODE", "356");
	  map.put("CUST_EMAIL", "rohit.singh@pay10.com");
	  map.put("CUST_NAME", "Rohit Kumar Singh");
	  map.put("ORDER_ID", "PAY10_"+gen());
	  map.put("PAY_ID", "pay_id given by pay10 team");    
	  map.put("RETURN_URL", "https://response.rs.bp.h.teamat.work");
	  map.put("TXNTYPE", "SALE");
	 
	  String hash = ChecksumUtils.generateCheckSum(map, "salt given by pay10 team");
	  StringBuilder httpRequest = new StringBuilder();

	  httpRequest.append("<HTML>");
	  httpRequest.append("<BODY OnLoad=\"OnLoadEvent();\" >");
	  httpRequest.append("<form name=\"form1\" action=\"");
	  httpRequest.append("https://secure.pay10.com/pgui/jsp/paymentrequest");
	  httpRequest.append("\" method=\"post\">");

	  httpRequest.append("<input type=\"hidden\" name=\"PAY_ID\" value=\"");
	  httpRequest.append(map.get("PAY_ID"));
	  httpRequest.append("\">");

	  httpRequest.append("<input type=\"hidden\" name=\"ORDER_ID\" value=\"");
	  httpRequest.append(map.get("ORDER_ID"));
	  httpRequest.append("\">");

	  httpRequest.append("<input type=\"hidden\" name=\"AMOUNT\" value=\"");
	  httpRequest.append(map.get("AMOUNT"));
	  httpRequest.append("\">");

	  httpRequest.append("<input type=\"hidden\" name=\"TXNTYPE\" value=\"");
	  httpRequest.append(map.get("TXNTYPE"));
	  httpRequest.append("\">");

	  httpRequest.append("<input type=\"hidden\" name=\"CUST_NAME\" value=\"");
	  httpRequest.append(map.get("CUST_NAME"));
	  httpRequest.append("\">");

	  httpRequest.append("<input type=\"hidden\" name=\"CUST_EMAIL\" value=\"");
	  httpRequest.append(map.get("CUST_EMAIL"));
	  httpRequest.append("\">");

	  httpRequest.append("<input type=\"hidden\" name=\"CURRENCY_CODE\" value=\"");
	  httpRequest.append(map.get("CURRENCY_CODE"));
	  httpRequest.append("\">");

	  httpRequest.append("<input type=\"hidden\" name=\"RETURN_URL\" value=\"");
	  httpRequest.append(map.get("RETURN_URL"));
	  httpRequest.append("\">");

	  httpRequest.append("<input type=\"hidden\" name=\"HASH\" value=\"");
	  httpRequest.append(hash);
	  httpRequest.append("\">");

	  httpRequest.append("</form>");
	  httpRequest.append("<script language=\"JavaScript\">");
	  httpRequest.append("function OnLoadEvent()");
	  httpRequest.append("{document.form1.submit();}");
	  httpRequest.append("</script>");
	  httpRequest.append("</BODY>");
	  httpRequest.append("</HTML>");

	  httpRequest.toString();
	  System.out.println(httpRequest.toString());

	 }
  

}


