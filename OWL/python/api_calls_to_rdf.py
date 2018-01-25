import requests
import json
import re

r = requests.get("https://api.coinmarketcap.com/v1/ticker/?limit=100")
ccys = r.content
ccys = json.loads(ccys.decode("utf-8"))

d = open("file.txt", "w")

for ccy in ccys:
    name = re.sub(" ", "_", ccy["name"])
    text = "###  http://purl.org/net/bel-epa/doacc#" + name + "\n\n"
    
    text += ":" + name +  " rdf:type <http://purl.org/net/bel-epa/doaccCryptocurrency> ,"
    text += " owl:NamedIndividual ;\n\n\t"
    
    text += ":price_USD \""  + ccy["price_usd"] +  "\"^^xsd:double ;\n\n\t"
    
    text += ":volume \""  + ccy["24h_volume_usd"] +  "\"^^xsd:double ;\n\n\t"
    
    text += ":maximum_supply \""  + ccy["total_supply"] +  "\"^^xsd:double ;\n\n\t"
    
    text += ":circulating_supply \""  + ccy["available_supply"] +  "\"^^xsd:double ;\n\n\t"
    
    text += ":market_capital \""  + ccy["market_cap_usd"] +  "\"^^xsd:double ;\n\n\t"
    
    text += ":abbreviation \""  + ccy["symbol"] +  "\"^^xsd:string ;\n\n\t"
    
    text += ":percent_change_24h \""  + ccy["percent_change_24h"] +  "\"^^xsd:double .\n\n\n\n"

    d.write(text)
    
d.close()

