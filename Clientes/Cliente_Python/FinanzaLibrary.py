import requests 
import json

def consumeGet():
    url_json = 'http://localhost:8080/finanza/lista'
    res = requests.get(url_json)
    body = res.text 
    print(body)

def consumePut(data):
    url_json = 'http://localhost:8080/finanza/editar'
    res = requests.put(url_json,data)
    print(res.status_code)

def consumeDelete(datos):
    url_json = 'http://localhost:8080/finanza/eliminar'
    res = requests.delete(url_json, data=datos)
    print(res.status_code)    

def consumePost(data):
    url_json = 'http://localhost:8080/finanza/crear'
    res = requests.post(url_json, data)
    print(res.status_code)
