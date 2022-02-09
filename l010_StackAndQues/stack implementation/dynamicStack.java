public class dynamicStack extends Stack {

  //constructor
  public dynamicStack() {
    super(); //super means parent class ko call krega ie in Stack, () -> these baracket are called constructor
  }

  public dynamicStack(int size) { //means to represent size and yeh cpacity hi hai
    super(size); //means parent ke paas jaega uska construtor size wala
  }

  //we make dynamic stack jo kbhi full na ho agara 1 file me krte toh client ko bol ki main file me beth kr file
  //access krr so wo bech nhi skta usko, so we make custom array jo oveerride krra hai

  public dynamicStack(int[] arr) {
    //this is for client ko aisa constructor chaiye jo 1 array de or vo stack me convert hoje
    super.initialiseVariable(2 * arr.length);

    for (int ele : arr) {
      super.push_(ele);
    }
  }

  @oveerride
  public void push(int data) throws Exception {
    //super or this are similar but super perform much better because vo pehle parent ke paas jata hai agar nhi milta
    //to iss file me check krta hai
    if (super.capacity == super.elementCount) {
      int[] temp = super.arr; //copy old data make a shallow copy

      super.initialiseVariable(2 * super.capacity); //make a new array for dynamic size

      //now pura data jo hai usko copy krege in new space
      for (int ele : temp) { //copy old data in new space
        super.push_(ele); // -> yeh stack ka underscore function hai jo add krta hai usko ovdr ride ni krre
      }
    }

    super.push(data); //stack me direct push call kra jo curr data add krna hai vo
    // or har baar overflow condtion bhi check krega, [we can also do push_(data) -> sirf direct data add krega]
  }
}
/*extend -> yeh link krta hai jis class ke sth krna hai ie 
     Stack -> it is parent class Extend krne ka baad likhte hai vo uski sari properties 
     inherit krta hai bass constructor nhi aata ,agar constructor ke andr ke method chaiye to use super keyword

    2) private member extend nhi hote ie why use protected

    3) super -> isse hm constructor bhi access kr skte hai parent ka and method bhi parent ke using dot
                eg: .capacity 

    4) aagr hmne super use kiya or constructor bhi bnaya ussi me toh preference new wale ko milegi

    5)  super or this are similar but super perform much better because vo pehle parent ke paas jata hai agar nhi milta
        to iss file me check krta hai

    */
