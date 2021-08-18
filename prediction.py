import tensorflow as tf
from keras.models import load_model

model = load_model('heart_disease_v1.h5')


x = ([[37. ,   1. ,   2. , 130. , 250. ,   0. ,   1. , 187. ,   0. ,
         3.5,   0. ,   0. ,   2. ,   1. ,   0. ,   1.]])

prediction = model.predict(x)

print(int(prediction[0]*100))