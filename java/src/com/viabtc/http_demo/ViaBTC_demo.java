package com.viabtc.http_demo;

import java.io.IOException;

import org.apache.http.HttpException;

import com.viabtc.http_demo.StockApi.MARKET;
import com.viabtc.http_demo.StockApi.ORDER_TYPE;

public class ViaBTC_demo {

	public static void main(String[] args) throws HttpException, IOException{
		
	    String access_id = ""; 
       	String secret_key = ""; 
 	    String url_prex = "https://api.viabtc.com/api/v1/";
	
	    StockApi api = new StockApi(url_prex, access_id, secret_key);
	    api.kline(MARKET.MARKET_BTCCNY, "1min");
	    
	    api.putLimitOrder(MARKET.MARKET_BTCCNY, ORDER_TYPE.ORDER_TYPE_BUY, 1, 1000);

	}
}
