import requests
import json
import re
import mysql.connector

r = requests.get("https://api.coinmarketcap.com/v1/ticker/?limit=100")
ccys = r.content
ccys = json.loads(ccys.decode("utf-8"))


def db_insert(ccys):
    cnx = mysql.connector.connect(user='b1823e5dc0f9c0', password='3d52c132',
                                 host='us-cdbr-iron-east-05.cleardb.net',
                                  database='ad_fd3f9cb8680c16c')
     
    #cnx = mysql.connector.connect(user='spring', password='spring',
    #                              host='127.0.0.1',
    #                              database='news')

	 
    cursor = cnx.cursor()

    add_employee = ("INSERT INTO top_coin (changevalue, abbreviation, market_cap, name, price, supply, volume) VALUES (%s,%s, %s, %s, %s, %s, %s)")
    for ccy in ccys:
        data_employee = [  float(ccy["percent_change_24h"]),
						   str(ccy["symbol"]),
                           float(ccy["market_cap_usd"]),
                           str(ccy["name"]),
                           float(ccy["price_usd"]),
                           float(ccy["available_supply"]),
                           float(ccy["24h_volume_usd"])]
        print(data_employee)
        cursor.execute(add_employee, data_employee)

    cnx.commit()

    cursor.close()
    cnx.close()
    
    
db_insert(ccys)
