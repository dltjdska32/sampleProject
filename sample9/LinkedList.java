package sample9;

public class LinkedList {
    private Node head;
    private Node tail;

    private int size = 0;

    private class Node {    // 하나의 노드(버텍스)는 하나의 객체
        private Object data; // 데이터필드
        private Node next; // 링크필드

        public Node(Object input) {   //생성자
            this.data = input;   //데이터필드에 인풋 저장
            this.next = null;    //링크 필드는 null
        }

     //   public String toString() {
      //      return String.valueOf(this.data);
      //  }
    }


    public void addFirst(Object input) {  //링크드리스트 처음에 추가
        Node newNode = new Node(input);   //새로운 인풋값을 가진 노드를 newNode에 저장
        newNode.next = head;      //  newNode가 가리키는 next는 현재의 헤드
        head = newNode;         // 헤드를 newNode로 변경
        size++;             // 노드 개수 추가
        if (head.next == null) {         //만약 헤드의 다음이 없으면
            tail = head;         // 꼬리와 헤드는 같다.
        }
    }

    public void addLast(Object input) {    //링크드리스트의 마지막에 추가
        Node newNode = new Node(input);  //새로운 인풋값을 가진 노드 생성
        if (size == 0) {        //사이즈가 0이면 - 데이터가없으면
            addFirst(input);   // addFirst 함수 사용해서  input 추가
        } else {          //사이즈가 1이상이면
            tail.next = newNode;  // 현재 리스트의 꼬리의 다음에 newNode추가
            tail = newNode;   // 꼬리는 newNode가 된다.
            size++; //사이즈 크기 1플러스
        }
    }

    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public void add(int k, Object input) {
        if (k == 0) { //k값에 0을 입력할 경우 제일 처음에 input 추가
            addFirst(input);
        } else {   //1 이상일경우 노드들 사이에 추가.
            Node temp1 = node(k - 1); // k값 앞에 노드를 temp1에 저장
            Node temp2 = temp1.next; //temp2에 temp1 다음 노드저장
            Node newNode = new Node(input); // input값을 가진 노드 생성
            temp1.next = newNode;
            newNode.next = temp2;
            size++;
            if (newNode.next == null) { //temp2가 없으면
                tail = newNode;       // input값을 가진 노드가 마지막
            }

        }

    }

  public String toString(){  // 객체를 출력하기 위한 함수
        if(head == null){  //헤드값이 없으면 []로 출력
            return "[]";
        }
        Node temp = head;
        String str = "["; // str의 첫 문자열은 [

        while(temp.next != null){  // temp의 다음이 없을때 까지 반복
            str += temp.data + ", ";  // [ 에 데이터와 ", "를 입력
            temp = temp.next;    //temp는 다음값으로 넘어감. 템프의 다음값이 null이면 탈출
        }
        str += temp.data;  // 리스트의 마지막 데이터의 다음이 null이기 때문에 와일문을 나옴 따라서 데이터 수동입력

        return str + "]";  // str에 저장된 값과 ] 값을 추가하여 반환
    }

    public Object removeFirst(){  //리스트의 첫번째 데이터 삭제
        Node temp = head;   //temp는 헤드
        head = temp.next;    // 헤드를 현재 헤드(temp)의 다음값으로 바꿈
        Object returnData = temp.data;  //데이터 삭제를 위해 temp의 데이터를 returnData에 저장
        temp = null; //템프를 null로 지정 (템프값 삭제)
        size--; //사이즈를 하나 줄임
        return returnData;  //리턴 데이터를 반환 (첫 번째 데이터 삭제)
    }

    public Object remove(int k){ // k번째 노드 제거
        if(k == 0){             //k == 0 이면
            return removeFirst();  //가장첫번째 노드 삭제
        }

        Node temp = node(k-1); //temp에 k번째 노드 앞에 노드를 저장
        Node todoDeleted = temp.next;  //k번째 노드를 todoDeleted에 저장
        temp.next = temp.next.next; //temp의 다음 다음 노드가 temp의 다음노드가됨.
        Object returnData = todoDeleted.data; //반환할 데이터는 삭제할노드의 데이터
        if(todoDeleted == tail){ // 삭제할 노드가 꼬리와 같다면
            tail = temp;   //temp가 꼬리가됨.
        }
        todoDeleted = null;   //삭제할 노드 삭제
        size--; //리스트 크기 감소
        return returnData;
    }

    public Object removeLast(){  //마지막 노드 제거
        return remove(size-1);   // 노드는 0부터 시작 사이즈는 1부터 시작 따라서 사이즈 -1
    }
    public int size(){   //리스트의 사이즈크기
        return size;
    }

    public Object get(int k){  //k번째노드의 데이터 반환
        Node temp = node(k);
        return temp.data;
    }
}

