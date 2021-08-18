### Install Anaconda first
### Then install  C++ redistributable and restart
[Link](https://aka.ms/vs/16/release/vc_redist.x64.exe)
```
conda create -n tf python=3.8
```
```
conda activate tf
```
```
pip install tensorflow==2.4.1 django djangorestframework django-cors-headers
```
### Start Server
```
python manage.py runserver
```