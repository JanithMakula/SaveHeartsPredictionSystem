import tensorflow as tf
from tensorflow.keras.models import load_model

def HPredict(x):
    model = load_model('heartPredictApp/subFunctions/pretrainedModels/heart_disease_v1.h5')

    prediction = model.predict(x)

    print(f'Prediction : {int(prediction[0]*100)}')

    return int(prediction[0]*100)