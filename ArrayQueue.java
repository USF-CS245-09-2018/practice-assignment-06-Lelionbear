import java.util.Arrays;

public class ArrayQueue implements Queue {

    private Object arr[];
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public ArrayQueue(){
        arr =  new Object[10];
//        head = -1;
    }

    public Object dequeue(){
        if (empty()){
            try {
                throw new Exception("....Empty Queue");
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
        Object obj = arr[head];
        head++;
        if (head >= arr.length)
            head=0;
        return obj;
    }
    public void enqueue(Object item){
        if ((tail+1) % arr.length == head)
            growArr();
        arr[tail] = item;
        tail++;
        if (tail >= arr.length) {
            tail = tail % arr.length;
        }
    }
    public boolean empty(){
        return head == tail;
    }

    private void growArr(){
        Object[] temp = new Object[arr.length*2];//Arrays.copyOf(arr,arr.length);
//        System.arraycopy(arr,head,temp,0,arr.length);
        int i,count = 0;
        if (tail < head){
            for (i = head; i < arr.length; i++){
                temp[count] = arr[i];
                count++;
            }
        }
        for (i = 0; i < tail; i++){
            temp[count] = arr[i];
            count++;
        }
        head = 0;
        tail = count;
        arr = temp;
    }
}
