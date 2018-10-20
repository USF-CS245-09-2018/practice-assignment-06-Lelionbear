public class ArrayStack implements Stack{
    private Object[] arr;
    private int top = -1;

    public ArrayStack(){
        arr = new Object[10];
    }

    public void push(Object item)
    {
        if (top == arr.length-1)
        {
            grow();
        }
        top++;
        arr[top] = item;
    }

    private void grow() {
        Object[] temp = new Object[arr.length*2];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }

    public Object pop()
    {
        if (empty())
        {
            try {
                throw new Exception("Stack Empty");
            }
            catch (Exception e){
                //do nothing
            }
        }
        top--;
        return arr[top+1];

    }
    public Object peek()
    {
        if (empty())
        {
            try {
                throw new Exception("Empty");
            }
            catch (Exception e){
                //do nothing
            }
        }
        return arr[top];
    }
    public boolean empty(){
        return top == -1;
    }
}
