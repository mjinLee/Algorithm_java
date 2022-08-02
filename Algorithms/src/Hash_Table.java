import java.util.LinkedList;

class HashTable {
    class Node{
        String key; // 검색할 key
        String value; // 검색 결과 보여줄 값
        // Node 생성-key,value 받아서 객체에 할당
        public Node(String key, String value){
            this.key = key;
            this.value = value;
        }
        String value(){
            return value;
        }
        void value(String value){
            this.value = value;
        }
    }
    // 데이터 저장할 LinkedList를 배열로 선언
    LinkedList<Node>[] data;
    // 배열 크기 설정
    HashTable(int size){
        this.data = new LinkedList[size];
    }
    // 해시함수. key 받아서 해시코드를 반환
    int getHashCode(String key){
        int hashcode = 0;
        // 입력받은 key(문자열)을 돌면서 각 문자의 ASCII값을 가져와
        // 해시코드에 더해줌
        for(char c:key.toCharArray()){
            hashcode += c;
        }
        return hashcode;
    }
    // 해시코드를 받아서 배열에 인덱스로 변환해줌
    int convertToIndex(int hashcode){
        // 해시코드를 배열의 크기로 나눈 나머지가 배열의 인덱스가 됨
        return hashcode % data.length;
    }
    // 인덱스로 배열을 찾은 이후에, 
    // 배열 안에 Node가 여러 개 존재하는 경우에
    // 검색 key를 가지고 해당 Node를 찾아오는 함수
    Node searchKey(LinkedList<Node> list, String key){
        if(list == null) return null;
        for(Node node : list){
            // Node의 key가 검색하려는 key와 같으면
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }
    // 데이터를 받아서 저장하는 함수
    void put(String key, String value){
        // key를 가지고 hashcode를 받아옴
        int hashcode = getHashCode(key);
        // 받아온 hashcode로 저장할 배열의 번호를 받아옴
        int index = convertToIndex(hashcode);
        // 배열 번호를 이용해서 기존 배열에 있던 데이터를 가져옴
        LinkedList<Node> list = data[index];
        // 배열이 null이면 
        if(list == null) {
            // LinkedList 생성
            list = new LinkedList<Node>();
            // 해당 list를 배열에 넣어줌
            data[index] = list;
        }
        // 배열에 기존에 해당 key로 데이터를 가지고 있는지
        // Node를 받아온다
        Node node = searchKey(list,key);
        if(node == null){
            // node가 null이면 데이터가 없다는 뜻이니까
            // 받아온 정보를 가지고 node 객체를 생성해서 
            // list에 추가
            list.addLast(new Node(key, value));
        }
        else{
            // node != null이면 해당 node의 값을 대체해주는 걸로
            // 중복key 처리
            node.value(value);
        }
    }
    // key를 가지고 데이터를 가져오는 함수
    String get(String key){
        // key를 가지고 hashcode를 받아옴
        int hashcode = getHashCode(key);
        // 받아온 hashcode로 저장할 배열의 번호를 받아옴
        int index = convertToIndex(hashcode);
        // 배열 번호를 이용해서 기존 배열에 있던 데이터를 가져옴
        // hashcode 와 index 출력
        System.out.println(key + ", hashcode("+hashcode+
            "), index("+index+")");
        LinkedList<Node> list = data[index];
        // LinkedList 안에 해당 key를 가지는 node를 검색
        Node node = searchKey(list, key);
        // node를 못 찾았으면 "Not found"
        // node를 찾았으면 값을 받아옴
        return node == null? "Not found" : node.value();
    }
}
public class Hash_Table {
    public static void main(String[] args){
        // HashTable을 3개로 고정된 배열 생성하고
        HashTable h = new HashTable(3);
        // 검색할 key와 value 주기
        h.put("kim", "She is smart");
        h.put("Lee", "He is a model");
        h.put("Choi", "He is awesome");
        h.put("Park", "She is a singer");
        h.put("kim", "She is brilliant");
        System.out.println(h.get("Kim"));
        System.out.println(h.get("Lee"));
        System.out.println(h.get("Choi"));
        System.out.println(h.get("Park"));
        System.out.println(h.get("You"));
    }
}