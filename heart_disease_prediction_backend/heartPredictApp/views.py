
from django.http import HttpResponse, JsonResponse
from django.http.response import HttpResponse
from rest_framework.decorators import api_view
from rest_framework.response import Response
from rest_framework import serializers, status
import json
from .subFunctions import gg, prediction
from .serializers import DataSerializer


def index(request):
    return HttpResponse('Welcome to heart diseas predict app')


@api_view(['POST'])
def getPredict(request):
    if request.method == 'POST':
        try:
            serializer = DataSerializer(data=request.data)

            if serializer.is_valid():
                x = ([[
                    float(serializer.data['age']),
                    float(serializer.data['sex']),
                    float(serializer.data['cp']),
                    float(serializer.data['trestbps']),
                    float(serializer.data['chol']),
                    float(serializer.data['fbs']),
                    float(serializer.data['restecg']),
                    float(serializer.data['thalach']),
                    float(serializer.data['exang']),
                    float(serializer.data['oldpeak']),
                    float(serializer.data['slope']),
                    float(serializer.data['ca']),
                    float(serializer.data['thal']),
                    float(serializer.data['ear']),
                    float(serializer.data['eye']),
                    float(serializer.data['cheek'])
                ]])
                res = prediction.HPredict(x)

                return Response({'prediction': f'{res}'}, status=status.HTTP_201_CREATED)
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
        except Exception as e:
            print(e)
            return Response({"Error": "something wrong"}, status=500)
