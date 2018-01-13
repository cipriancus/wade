from requests import get

r = get('http://localhost:5000/Bitcoin').json()
print(r)
