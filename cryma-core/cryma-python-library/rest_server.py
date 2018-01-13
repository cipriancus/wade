from flask import Flask
from flask_restful import Resource, Api

import os
import numpy as np
import pandas as pd
from keras.models import model_from_json


def get_price_data(coinId, startDate, endDate, normalized=0):
    name = os.path.join("Top100Cryptos", coinId + ".csv")
    col_names = ['Date', 'Open', 'Value', 'Low Close', 'Volume', 'Market Cap']
    history = pd.read_csv(name, header=0, names=col_names)
    df = pd.DataFrame(history)
    df.drop(df.columns[[0, 1, 3, 4, 5]], axis=1, inplace=True)
    df["Value"] = df["Value"] / max(df["Value"])
    data = df[::-1].as_matrix()
    return data


def load_data(data, seq_len):
    result = []
    seq_len += 1
    for index in range(len(data) - seq_len):
        result.append(data[index: index + seq_len])

    result = np.array(result)
    split_row = int(round(0.9 * result.shape[0]))
    train = result[:split_row, :]
    x_train = train[:, :-1]
    y_train = train[:, -1][:, -1]
    test = result[split_row:, :]
    x_test = test[:, :-1]
    y_test = test[:, -1][:, -1]

    x_train = np.reshape(x_train, (x_train.shape[0], x_train.shape[1], 1))
    x_test = np.reshape(x_test, (x_test.shape[0], x_test.shape[1], 1))

    return [x_train, y_train, x_test, y_test]


app = Flask(__name__)
api = Api(app)


class HelloWorld(Resource):
    def __init__(self):
        json_file = open('model.json', 'r')
        loaded_model_json = json_file.read()
        json_file.close()
        self.model = model_from_json(loaded_model_json)
        self.model.load_weights("crypto_pred.h5")

    def get(self, coinId, startDate=0, endDate=5):
        data = get_price_data(coinId, startDate, endDate)
        X_train, y_train, self.X_test, y_test = load_data(data[::-1], 5)
        p = self.model.predict(self.X_test)
        print(p[-6:])
        self.X_test = self.X_test[-6]
        predictions = []
        for i in range(startDate, endDate):
            inpt = np.expand_dims(self.X_test, axis=0)
            p = self.model.predict(inpt)
            self.X_test = self.X_test[1:]
            self.X_test = np.vstack((self.X_test, (p[0][0])))
            # print(self.X_test)
            print(p)
            predictions.append(str(p[0][0]))
        return {"pred": predictions}


# api.add_resource(HelloWorld, '/')
api.add_resource(HelloWorld, '/<coinId>')


if __name__ == '__main__':
    app.run(debug=True)

# @PathVariable(value = "coinId") String coinId,
# @RequestParam(value = "startDate") String startDate,
# @RequestParam(value = "endDate") String endDate
