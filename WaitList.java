public class WaitList {

  String user;
  WaitList next;
  WaitList start;

  WaitList(String user) {
    this.user = user;
    next = null;
    start = this;
  }

  WaitList() {
  }

  void AddInBeg(String user) {
    WaitList newNode = new WaitList(user);
    // list is empty
    if (start == null) {
      start = newNode;
    } else {
      WaitList temp = start;
      start = newNode;
      start.next = temp;
    }
  }

  void RemoveLast() {
    if (start == null || start.next == null) {
      return;
    }

    WaitList temp = start;
    while (temp.next.next != null) {
      temp = temp.next;
    }
    temp.next = null;
  }

  void Remove(String user) {
    // if its first
    if (user.equals(this.start.user)) {
      this.start = this.start.next;
      return;
    }

    WaitList temp = start, prev = start;

    while ((temp = temp.next) != null) {
      if (user.equals(temp.user)) {
        prev.next = temp.next;
        return;
      }
      prev = temp;

    }


  }

  void printList() {
    if (start == null) {
      return;
    }
    WaitList current = start;
    while (current != null) {
      System.out.println(current.user);
      current = current.next;
    }
  }


}
