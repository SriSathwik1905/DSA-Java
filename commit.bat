@echo off
cd C:\Users\padal\OneDrive\Desktop\DSA JAVA
set /p user_input="commit message bro: "
git add .
git commit -m %user_input%