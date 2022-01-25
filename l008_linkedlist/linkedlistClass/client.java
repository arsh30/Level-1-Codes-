public class client {

  public static void main(String[] args) {
    linkedlist l1 = new linkedlist();
    for (int i = 0; i <= 10; i++) {
      l1.addLast(i * 10);
    }
    // l1.display();
    l1.getFirst();
  }
}
