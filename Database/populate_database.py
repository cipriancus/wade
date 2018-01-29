import requests
import json
import re
import mysql.connector

r = requests.get("https://api.coinmarketcap.com/v1/ticker/?limit=100")
ccys = r.content
ccys = json.loads(ccys.decode("utf-8"))


def db_insert(ccys):
    cnx = mysql.connector.connect(user='', password='',
                                  host='us-cdbr-iron-east-05.cleardb.net',
                                  database='ad_050ed236667031b')
      
    cursor = cnx.cursor()

    add_employee = ("INSERT INTO top_coin (changevalue, market_cap, name, price, supply, volume) VALUES (%s, %s, %s, %s, %s, %s)")
    for ccy in ccys:
        data_employee = [float(ccy["percent_change_24h"]),
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
