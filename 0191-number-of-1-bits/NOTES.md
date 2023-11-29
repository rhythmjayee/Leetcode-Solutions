**1. Method I**
n = 8 = 1000
n - 1 = 7 = 0111
n & n - 1 = 0000
```
while(n != 0){
n = n&(n-1); //remove last most set bit
count++;
}
```
​
**2. Method II**
n = 8 = 1000
n = -8 = 11111111111111111111111111111000
RMSB = n & -n = 1000 => Right most set bit
n - RMSB = 0000
​
```
while(n!=0){
int rms=n&(-n);
n=n-rms;
count++;
}
```
​