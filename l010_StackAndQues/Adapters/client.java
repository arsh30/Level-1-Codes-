public class client {

  public static void main(String[] args) {
    //queueUsingStack_push_Efficient que = new queueUsingStack_push_Efficient();
    // queueUsingStack_popEfficient que = new queueUsingStack_popEfficient();
    // stackUsingQueue_push que = new stackUsingQueue_push();
    stackUsingQueue_pop que = new stackUsingQueue_pop();

    for (int i = 0; i <= 10; i++) {
      que.push(i * 10);
    }

    while (que.size() != 0) {
      System.out.println(que.pop());
    }
  }
}
