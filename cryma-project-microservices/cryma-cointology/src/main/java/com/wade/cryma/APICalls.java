package com.wade.cryma;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class APICalls {
	private RestTemplate restTemplate = new RestTemplate();
	private String requestString = "https://api.coinmarketcap.com/v1/ticker/bitcoin/";

	public void getCoins() {
		ResponseEntity<CoinInfo[]> coinInfo = restTemplate.getForEntity(requestString, CoinInfo[].class);
		CoinInfo[] info = coinInfo.getBody();
		if (info != null){
			for(int iterator=0;iterator<info.length;iterator++) {
				System.out.println(info[iterator].price_usd);
			}
		}
	}
}
