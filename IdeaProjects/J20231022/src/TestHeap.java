import java.util.Arrays;

public class TestHeap {
    private int[] elem;

    public int usedSize;//记录当前堆当中有效的数据个数

    public TestHeap(){
        this.elem = new int[10];
    }

    public void initElem(int[] array){
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

    public void createHeap(){
        //usedSize-1相当于最后一棵树孩子结点的下标i，再-1是为了求父结点
        for (int parent = (usedSize-1-1)/2; parent >= 0; parent--) {
            siftDown(parent,usedSize);
        }
    }

    /**
     * 向下调整
     * @param parent
     * @param len
     */
    private void siftDown(int parent, int len){
        int child = 2 * parent + 1;
        while(child < len){
            //左右孩子比较大小
            if(child+1<len && elem[child] < elem[child + 1]){
                child = child + 1;
            }
            //走完上面的if，证明child下标一定是左右两个孩子最大值的下标
            if(elem[child] > elem[parent]){
                swap(child,parent);
                parent = child;
                child = 2 * parent + 1;
            }else{
                break;//不用比不用调了
            }
        }
    }

    public void swap(int i, int j){
        int tmp = elem[i];
        elem[i] = elem[j];
        elem[j] = tmp;
    }
    public void push(int val){
        if(isFull()){
            elem = Arrays.copyOf(elem, 2*elem.length);
        }
        elem[usedSize] = val;
        //向上调整
        siftUp(usedSize);
        usedSize++;
    }
    //判断满不满
    public boolean isFull(){
        return usedSize == elem.length;
    }
    public void siftUp(int child){
        int parent = (child - 1) / 2;
        while(child>0){
            if(elem[child] > elem[parent]){
                swap(child,parent);
                child = parent;
                parent = (child - 1) / 2;
            }else{
                break;
            }
        }
    }

    public int pop(){
        if(empty()){
            throw new EmptyException("数组空了！");
        }
        int oldVal = elem[0];
        swap(0,usedSize-1);
        usedSize--;
        siftDown(0,usedSize);
        return oldVal;
    }

    public boolean empty(){
        return usedSize == 0;
    }

    public void heapSort(){
        int end = usedSize-1;
        while(end>0){
            swap(0,end);
            siftDown(0,end);
            end--;
        }
    }
}
