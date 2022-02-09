public class client {

  // public static void main(String[] args) throws Exception{
  //     dynamicQueue que = new dynamicQueue(6);
  //     for(int i = 0; i < 10; i++){
  //         que.push(i * 100);
  //     }

  //     System.out.print(que);
  // }
  public static void main(String[] args) throws Exception {
    dynamicQueue que = new dynamicQueue(16);
    for (int i = 0; i < 15; i++) que.push(i * 100);

    System.out.print(que);
  }
}
/* HOW TO RUN THESE FILE -> They run through the polymorphism commands
1) make client file
2) in cmd -> javac client.java && java client.java

3) Extra feature implement-> jb array list ko print krte the to sidha likhte the  syso(arr) then puri list print hojati thi
    if we do this here then it prints ->System.out.print(que); op ->  queue@3bd94634 that its address

    so we implement that feature


*/
