package test;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("sung","she is pretty");
        h.put("jin", "she is a model");
        h.put("hee", "she is an angel");
        h.put("min", "she is cute");
        System.out.println(h.get("sung"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("min"));
        System.out.println(h.get("jae"));

        h.put("sung", "she is beautiful");
        System.out.println(h.get("sung"));
    }
}

class  HashTable{

    //seperate chaining
    // 해쉬맵을 구현할경우 해쉬콜리젼이 발생할 수 있는데 이 문제를 해결하기 위해
    //seperate chaining 과 open addressing이 있다.
    //seperate chaining 의 경우 해쉬콜리젼이 발생할 경우 중복된 인덱스의 값에 위치한 값에 링크드리스트로 연결하는것
    //open addressing(linear probing) 의 경우 중복된 인덱스 값을 가지는 값의 경우 가까운 인덱스 위치에 해당 값을 위치시키는것
    // 본 알고리즘은 seperatechaining 방식을 구현함.
    class Node{
        //해쉬테이블에 저장할 값을 노드에 저장
        String key;
        String value;

        // 노드를 생성할때 키와 값을 받아서 노드를 생성
        public Node(String key, String value){
            this.key = key;
            this.value =value;
        }
        String value(){
            return value;
        }
        void value(String value){
            this.value = value;
        }
    }

    //데이터를 저장할 링크드리스트를 배열로 선언, 링크드리스트에는 노드가 저장
    LinkedList<Node>[] data;

    // 해쉬테이블을 선언할때 해쉬테이블의 크기를 선언 하고 배열을 만든다.
    HashTable(int size){
        this.data = new LinkedList[size];
    }

    //키값을 받아와서 해쉬코드를 반환
    int getHasheCode(String key){
        //해쉬코드를 0으로 초기화
        int hashcode = 0;

        //포 이치 문을 돌면서 해당 키에 저장되어 있는 문자열을 문자로 쪼개고
        //쪼개진 문자를 아스키코드의 정수로 바꾸고 문자의 아스키코드값을 모두 더해서 해쉬코드를 설정
        for(char c : key.toCharArray()){
            hashcode += c;
        }
        return hashcode;
    }

    //해쉬코드를 받아와서 배열방의 인덱스로 변환하는 함수
    //해쉬코드 값을 배열방 크기로 나눈 나머지 값을 인덱스 값으로 한다.
    int convertToIndex(int hashcode){
        return hashcode % data.length;
    }

    //인덱스로 배열방을 찾고 배열방에 노드가 여러개 존재할 경우
    //검색키를 가지고 해당노드를 찾는 함수
    Node searchKey(LinkedList<Node> list, String key){
      // 배열방이 null 이면 null을반환
        if(list == null){
            return null;
        }
        //배열방이 null이 아니면 배열방에 있는 링크드 리스트를 돌면서
        //노드의 키가 검색하는 키와 같으면 노드를 반환
        for(Node node : list){
            if(node.key.equals(key)){
                return node;
            }
        }
        //같은 데이터를 못찾으면 null반환
        return null;
    }

    //데이터를 받아서 저장하는 함수 저장할 키와 값을 받는다.
    void put(String key, String value){
        //키를 가지고 해쉬코드를 받는다.
        int hashcode = getHasheCode(key);
        //해쉬코드로 저장할 인덱스 값을 받아온다.
        int index = convertToIndex(hashcode);
        //해당 인덱스값을 가진 배열방의 링크드리스트를 가져온다.
        LinkedList<Node> list = data[index];
        //만약 리스트가 없으면
        if(list == null){
            //링크드리스트를 생성
            list = new LinkedList<Node>();
            //해당리스트를 배열방에 넣어줌
            data[index] = list;
        }
        //해당키로 데이터를 가지고있는지 노드를 받아옴.
        Node node = searchKey(list, key);
        //노드가 null일경우 데이터 없음.
        if(node == null){
            //받아온 정보로 노드객체를 생성하여 리스트에 추가
            list.addLast(new Node(key, value));
        }else{
            // 노드가 null이 아닐경우 해당노드의 값을 대체해줌
            node.value(value);
        }
    }

    //키를 가지고 값을 가져오는함수
    String get(String key){
        //키값으로 해쉬코드를 받아온다.
        int hashcode = getHasheCode(key);
        // 해쉬코드로 인덱스 값을 찾는다.
        int index = convertToIndex(hashcode);
        //해당 인덱스의 링크드리스트를 가져온다.
        LinkedList<Node> list = data[index];
        //해당 리스트에서 찾는 키값을 가지는 노드를 찾는다.
        Node node = searchKey(list, key);
        // 찾는 키 값을 가지는 노드가 없으면 not found 를 있다면 해당 키값을 가지는 값을 반환
        return node == null ? "not found" : node.value();
    }
}

