import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from pandas import datetime
import math, time
import itertools
from sklearn import preprocessing
import datetime
from operator import itemgetter
from sklearn.metrics import mean_squared_error
from math import sqrt
from keras.models import Sequential
from keras.layers.core import Dense, Dropout, Activation
from keras.layers.recurrent import LSTM

def get_price_data(normalized=0):
    name="btccUSD.csv" 
    col_names = ['Date','Value','MarketCap']
    history = pd.read_csv(name, header=0, names=col_names) 
    df = pd.DataFrame(history) 
    df.drop(df.columns[[0,2]], axis=1, inplace=True)
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
    
    
def build_model(layers):
    model = Sequential()

    model.add(LSTM(
        input_dim=layers[0],
        output_dim=layers[1],
        return_sequences=True))
    model.add(Dropout(0.2))

    model.add(LSTM(
        100,
        return_sequences=False))
    model.add(Dropout(0.2))

    model.add(Dense(layers[2]))
    model.add(Activation("linear"))

    model.compile(loss="mse", optimizer="rmsprop")
    return model

    
def build_model2(layers):
        d = 0.2
        model = Sequential()
        model.add(LSTM(128, input_shape=(layers[1], layers[0]), return_sequences=True))
        model.add(Dropout(d))
        model.add(LSTM(64, input_shape=(layers[1], layers[0]), return_sequences=False))
        model.add(Dropout(d))
        model.add(Dense(16,init='uniform',activation='relu'))        
        model.add(Dense(1,init='uniform',activation='linear'))
        model.compile(loss='mse',optimizer='adam',metrics=['accuracy'])
        return model
    
window = 5
data = get_price_data()
X_train, y_train, X_test, y_test = load_data(data[::-1], window)
print("X_train", X_train.shape)
print("y_train", y_train.shape)
print("X_test", X_test.shape)
print("y_test", y_test.shape)

model = build_model([1,window,1])
model.fit(
    X_train,
    y_train,
    batch_size=128,
    epochs=1,
    validation_split=0.2,
    verbose=1)

# trainScore = model.evaluate(X_train, y_train, verbose=0)
# print('Train Score: %.2f MSE (%.2f RMSE)' % (trainScore[0], math.sqrt(trainScore[0])))

# testScore = model.evaluate(X_test, y_test, verbose=0)
# print('Test Score: %.2f MSE (%.2f RMSE)' % (testScore[0], math.sqrt(testScore[0])))

model_json = model.to_json()
with open("model.json", "w") as json_file:
    json_file.write(model_json)
model.save('crypto_pred.h5')

diff=[]
ratio=[]
p = model.predict(X_test)
for u in range(len(y_test)):
    pr = p[u][0]
    ratio.append((y_test[u]/pr)-1)
    diff.append(abs(y_test[u]- pr))

import matplotlib.pyplot as plt2

plt2.plot(p,color='red', label='prediction')
plt2.plot(y_test,color='blue', label='y_test')
plt2.legend(loc='upper left')
plt2.show()
