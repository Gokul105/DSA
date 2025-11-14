package Arrays;

public class Array {
    private int[] numbers;
    private int count = 0 ;
    Array(int n){
      numbers = new int[n];
    }
    void print(){
        for ( int i = 0 ;i < count;i++){
            System.out.println(numbers[i]);
        }
    }
    void insert(int n){
        if(count == numbers.length){
            int[] newNumbers = new int[count * 2];
            for (int i = 0; i< count ; i++)
            {
              newNumbers[i] = numbers[i];
            }
            numbers = newNumbers;
        }
        numbers[count ++] = n;
    }
    void removeAt(int n){
        if (n<0 || n>= count){
            throw new IllegalArgumentException();
        }
        for (int i = n; i < count-1 ; i++){
            numbers[i] = numbers[i+1];
        }
       count --;
    }
    int indexOf(int n){
        for (int i = 0; i < count ; i++){
            if (numbers[i] == n){
                return i;
            }
        }
        return -1;
    }
}
