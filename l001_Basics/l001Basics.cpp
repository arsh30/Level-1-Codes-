#include <iostream>
using namespace std;

//making function
int multiply(int a , int b) {
    int c = a * b;
    return c;
}
int add(int a , int b) {
    int c = a + b;
    return c;
}
int subtract(int a , int b) {
    int c = a - b;
    return c;
}
int divide(int a , int b) {
    int c = a / b;
    return c;
}
void printMessage() {
    cout << "hello this is arsh" << endl;
}

int main()
{
    // cout << "hello " <<endl;   //endl is for new line
    //  cout << "pepcoders";
    // int a, b;
    // cin >> a >> b;
    // cout << a * b << endl;
    // // now do add then divide then subtract
    // cout << a - b << endl;
    // cout << a + b << endl;
    // cout << a * b << endl;   //ab multipy ka code we already write so kya ab hum dubara likhege no we will write only function
   
    int a, b;  //function ke liye input bhi uthaya jaega
    cin >> a >> b;  //yeh function ke liye user se input liya
     
 int c = multiply(a, b);  //note return type: jb function kuch return krta hai toh usko jab call krte hai to kisi variable me catch krke krte hai
 cout << c << endl;

 printMessage();  //note: if return type is void : toh hm kisi cheez me catch nahi krege
 return 0;
}