from django.urls import path

from .views import index, getPredict

urlpatterns = [
    path('', index),
    path('getpredict', getPredict)
]
