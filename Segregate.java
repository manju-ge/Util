class Segregate 
{
    /*Function to put all 0s on left and all 1s on right*/
    void segregate0and1(int arr[], int size) 
    {
        /* Initialize left and right indexes */
        int left = 0, right = size - 1;
 
        while (left < right) 
        {
            /* Increment left index while we see 0 at left */
            while (arr[left] == 0 && left < right)
               left++;
 
            /* Decrement right index while we see 1 at right */
            while (arr[right] == 1 && left < right)
                right--;
 
            /* If left is smaller than right then there is a 1 at left
               and a 0 at right.  Exchange arr[left] and arr[right]*/
            if (left < right) 
            {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
     
    /* Driver Program to test above functions */
    public static void main(String[] args) 
    {
        Segregate seg = new Segregate();
        int arr[] = new int[]{0, 1, 0, 1, 1, 1};
        int i, arr_size = arr.length;
 
        seg.segregate0and1(arr, arr_size);
 
        System.out.print("Array after segregation is ");
        for (i = 0; i < 6; i++)
            System.out.print(arr[i] + " ");
    
            String a= "gem";
            String b = new String("gem");

            funct();
            System.out.println(a==b);

        int barr[] = {0,1,2,3}; 
        arr = barr;
        for(int s: arr)  
            System.out.println(s+"");
    }

public static void funct(){
    int arr[] = {1,1,1,0,0,1,0,1,0};
int min=arr[0];
int swapCounter=0;
for(int i=1;i<arr.length;i++){
    if(arr[i]<arr[swapCounter]){
        swap(swapCounter,i,arr);
        swapCounter++;
    }

}
   for(int i=0;i<arr.length;i++)
    System.out.print(arr[i]);
}


public static void swap(int indx1,int indx2, int[] arr){
    int temp=arr[indx1];
    arr[indx1]=arr[indx2];
    arr[indx2]=temp;
}

}