public class dynamicQueue extends queue {

  //constructor
  public dynamicQueue() {
    super(); //default constructor of the parent class
  }

  public dynamicQueue(int size) {
    super(size); //
  }

  //making constructor-> user want that he paas an array, and they will egt converted into queue
  public dynamicQueue(int[] arr) {
    super.initialiseVariable(2 * arr.length); //double size kra

    for (int ele : arr) { //double size ka array bnaya
      super.push_(ele); //this function added elements one by one
    }
  }

  @Override
  public void push(int data) throws Exception {
    // if (super.capacity == super.elementCount) { //means size is full
    //   int n = super.capacity;
    //   int[] temp = new int[n]; //1st create new array
    //   for (int i = 0; i < n; i++) { //2nd step is copy old data into temp taki jab create kre to data gayab na hoje
    //     int idx = (this.front + i) % n; //isme jese display likha the vese ik ik krke copy krege
    //     temp[i] = super.arr[idx];
    //   }

    //   super.initialiseVariable(2 * n); // 3rd is making double aaray
    //   for (int ele : temp) { //4th step  is to add the elements into double size array
    //     super.push_(ele);
    //   }

    //   //one data is still we add them manually
    //   super.push_(data);
    // }

    if (super.capacity == super.elementCount) {
      int n = super.capacity;
      int f = super.front;
      int[] temp = super.arr;

      super.initialiseVariable(2 * n);
      for (int i = 0; i < n; i++) {
        int idx = (f + i) % n;
        super.push_(temp[idx]);
      }
    }

    super.push_(data);
  }
}
