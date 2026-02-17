public class Array {
    public static void main(String[] args) {
        int[] a1={1,2,3,4,5};
        //int[] a= new int[5];
        //a[0]=1;
        //a[1]=2;
        //a[2]=3;
        //a[3]=4;
        //a[4]=5;
        System.out.println("Length of array is:" +a1.length);
        for(int i=0;i<a1.length;i++){
            System.out.println("Print the array:"+a1[i]);
        }
        int[][] matrix=new int[2][2];
        matrix[0][0]=1;
        matrix[0][1]=2;
        matrix[1][0]=3;
        matrix[1][1]=4;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.println("Matrix:" +matrix[i][j]);
            }
        }
    }
}
