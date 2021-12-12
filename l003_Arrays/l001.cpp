#include <iostream>
#include <vector>
using namespace std;

void display(vector<int> &arr)
{ //array pass kra reference pass hota hai means exact copy
    //& -> jbhi function me pass krege tbhi & lgaege it is very import agar na aaya to tle aajega
    for (int i = 0; i < arr.size(); i++)
    { //arr.length -> java function to find length
        cout << arr[i] << " ";
    }
}

void test1()
{
    int n;
    cin >> n;
    //how to declare array
    vector<int> arr(n, 0); //means n size vector and default value is 0
    for (int i = 0; i < n; i++)
    { //input take
        cin >> arr[i];
    }

    //to output
    display(arr); //yeh reference pass hua hai exact copy upr
}
int main()
{
    test1();
    return 0;
}