import time
from flask import Flask, jsonify
import requests

app = Flask(__name__)

def obter_cotacao_dolar():
    
    api_url = "https://api.exchangerate-api.com/v4/latest/USD"
    
    try:
        response = requests.get(api_url)
        data = response.json()
        cotacao_dolar = data["rates"]["BRL"]
        return cotacao_dolar
    except Exception as e:
        print(f"Erro ao obter cotação do dólar: {e}")
        return None

@app.route("/cotacao-dolar", methods=["GET"])
def cotacao_dolar():
    cotacao = obter_cotacao_dolar()
    
    if cotacao is not None:
        return jsonify({"cotacao_dolar": cotacao})
    else:
        return jsonify({"erro": "Erro ao obter cotação do dólar"}), 500   
    

if __name__ == "__main__":
    app.run(debug=True)


while True:
    cotacao = obter_cotacao_dolar()
    print(cotacao)
    time.sleep(30)
