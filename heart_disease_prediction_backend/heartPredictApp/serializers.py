from rest_framework import serializers

class DataSerializer(serializers.Serializer):
    age = serializers.DecimalField(max_digits=10, decimal_places=2)
    sex = serializers.DecimalField(max_digits=10, decimal_places=2)
    cp = serializers.DecimalField(max_digits=10, decimal_places=2)
    trestbps = serializers.DecimalField(max_digits=10, decimal_places=2)
    chol = serializers.DecimalField(max_digits=10, decimal_places=2)
    fbs = serializers.DecimalField(max_digits=10, decimal_places=2)
    restecg = serializers.DecimalField(max_digits=10, decimal_places=2)
    thalach = serializers.DecimalField(max_digits=10, decimal_places=2)
    exang = serializers.DecimalField(max_digits=10, decimal_places=2)
    oldpeak = serializers.DecimalField(max_digits=10, decimal_places=2)
    slope = serializers.DecimalField(max_digits=10, decimal_places=2)
    ca = serializers.DecimalField(max_digits=10, decimal_places=2)
    thal = serializers.DecimalField(max_digits=10, decimal_places=2)
    ear = serializers.DecimalField(max_digits=10, decimal_places=2)
    eye = serializers.DecimalField(max_digits=10, decimal_places=2)
    cheek = serializers.DecimalField(max_digits=10, decimal_places=2)