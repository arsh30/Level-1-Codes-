import java.util.ArrayList;

//we make downheapify -> jiska kam hai apne aap ko heap me convert krna
public class heap {

  private ArrayList<Integer> arr = new ArrayList<>(); //arr jispr travel krege
  private int size = 0;
  private boolean isMax = true;

  private void initialise(boolean isMax) {
    this.arr = new ArrayList<>();
    this.size = 0;
    this.isMax = isMax; //default behaviour
  }

  //constructor
  public heap() {
    initialise(true);  //bydefault max pq
  }

  /*constructor2-> 2 tarike ke log heap bna skte hai 1) 1 person jo baar baar data add krega 
    so jabhi add krega to add function call krege
    2) aray provide krdege
    */

  public heap(int[] arr, boolean isMax) { //total tc -> nlog(n), isMax -> jab yeh call krege to batayenge ki yeh max pq hai agar hai to vo bhjege
    initialise(isMax);
    for (int ele : arr) this.arr.add(ele); //yeh array wala jo user ne diya usse hm put krre hai in our array

    //so we want to convert this into heap so hm last se start krege
    for (int i = this.arr.size() - 1; i >= 0; i--) { //tc n
      downHeapify(i); //tc complexi -> log(n)
    }
    this.size = arr.length;
  }

  //General functions
  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void add(int data) {
    this.arr.add(data); //add the data in the last
    this.size++;
    upHeapify(this.size - 1); //piche se start krra
  }

  public int remove() {
    int n = this.arr.size();
    int rv = this.arr.get(0); //return krna h so we have to catch this

    swap(0, n - 1);
    this.arr.remove(n - 1);
    this.size--;

    downHeapify(0);
    return rv;
  }

  public int peek() {
    return this.arr.get(0);
  }

  private int compareTo(int a, int b) {
    if (isMax) { //bydefault it is ax priority ques agar yeh hai to a wale ko priority milni chahiye
      return this.arr.get(a) - this.arr.get(b);
    } else {
      return this.arr.get(b) - this.arr.get(a); //min priority queue bnare hai or we want ki a wale ko hi priority mile aisa krne ke liye hme krna hoga jo value aayegi uske aage negative lgana hoga
    }
  }

  private void swap(int i, int j) {
    //arrayList me swap krre hai to element nikalege phle
    int ei = arr.get(i); //1st grab the values
    int ej = arr.get(j);

    arr.set(i, ej);
    arr.set(j, ei);
  }

  private void upHeapify(int childIdx) { //this is to add the data
    int pi = (childIdx - 1) / 2;
    if (pi >= 0 && compareTo(childIdx,pi) > 0) { //agra ci wale quantity bdi hojati hai to usse preference denge
      swap(pi, childIdx);
      upHeapify(pi);
    }
  }

  private void downHeapify(int pi) { //ik index milega or array jo hai upr se iterate krege
    int maxIdx = pi; //assume krra isko starting me
    int leftChild = 2 * pi + 1;
    int rightChild = 2 * pi + 2;

    //point is kya jisko hmne maxidx kya vo schme maxIdx hai, so check krege ki exist kon krta hai
    // if (leftChild < arr.size() && arr.get(maxIdx) < arr.get(leftChild)) {
    if (leftChild < arr.size() && compareTo(leftChild,maxIdx) > 0) {
      maxIdx = leftChild;
    }
    if (rightChild < arr.size() && compareTo(rightChild,maxIdx) > 0) {
      maxIdx = rightChild;
    }
    //above two if's will compare the maxIdx; maxIdx usko point krega jiski priority jyda hai

    if (maxIdx != pi) { //agar equal hai means heap hai
      /* 1st assume krege maxidx parentidx hi hai then agar left, ya right  
    bda hai toh maxIdx se to swap krege, or jidr maxIdx gya hai udr ke element 
    bigad jayege to dubara heap find krege so again recursuion apply krege
    */
      swap(maxIdx, pi);
      downHeapify(maxIdx);
    }
  }
}
