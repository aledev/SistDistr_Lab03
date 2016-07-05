import requests 
import json

def consumeGet():
    url_json = 'http://localhost:8080/finanza/lista'
    res = requests.get(url_json)
    body = res.text 
    print(body)

def consumePut(identificador,nomPer,fchMov,saldoMov):
    url_json = 'http://localhost:8080/finanza/editar'
    data = { id : identificador,
			nombrePersona: nomPer,
  			fchMovimiento: fchMov,
  			saldoMovimiento: saldoMov
    }
    res = requests.post(dest,data)
    body = res.text 
    print(body)

def consumeDelete(identificador):
    url_json = 'http://localhost:8080/finanza/eliminar'
    data = { id : identificador }
    res = requests.delete(dest, data)
    body = res.text
    print(body)

def consumePost(data):
    url_json = 'http://localhost:8080/finanza/crear'
    res = requests.post(url_json, data)
    print(res.status_code)
