public class FindEquilibriumIndex {

    public static void main(String arg[]){
        int A[] = {1,2,3,4,3,2,1};
        System.out.println("Equilibrium Index Using Brute Force  : "+SearchEquilibriumIndex(A,A.length));
        System.out.println("Equilibrium Index Using Prefix  : "+SearchEquilibriumIndexUsingPrefix(A,A.length));
        System.out.println("Equilibrium Index Using Single loop   : "+SearchEquilibriumIndexUsingSingleLoop(A,A.length));
        System.out.println("Equilibrium Index Using Prefix Sum Of The Array Twice : "+SearchEquilibriumIndexUsingPrefixSumOfTheArrayTwice(A,A.length));
    }


    static int SearchEquilibriumIndex(int A[],int n){
        int leftSum;
        int rightSum;

        for (int i = 0; i < n; i++){
            leftSum = 0;
            for (int j = 0; j<i; j++){
                leftSum = leftSum + A[j];
            }

            rightSum = 0;
            for (int j = i+1; j<n; j++){
                rightSum = rightSum + A[j];
            }

            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }

    static int SearchEquilibriumIndexUsingPrefix(int A[],int n){

        int prefix[]=new int[n];

        for (int i = 0; i < n; i++)
        {
            if(i==0)
                prefix[i] = A[i];
            else
                prefix[i] = A[i] + prefix[i-1];
        }
        int totalsum = prefix[n-1];
        for(int i = 0 ; i < n; i++)
        {
            int leftsum = prefix[i] - A[i];
            int rightsum = totalsum - prefix[i];
            if(leftsum == rightsum)
                return i ;
        }
        return -1;
    }

    static int SearchEquilibriumIndexUsingSingleLoop(int A[],int n){

        int totalsum = 0;
        int leftsum = 0;

        for (int i = 0; i < n; i++)
        {
            totalsum = totalsum + A[i];
        }

        for(int i = 0 ; i < n; i++)
        {
            int rightsum = totalsum - leftsum - A[i];
            if(leftsum == rightsum)
                return i ;
            leftsum = leftsum + A[i];
        }
        return -1;
    }

    static int SearchEquilibriumIndexUsingPrefixSumOfTheArrayTwice(int A[],int n){

        int leftside[] = new int[n];
        int rightside[] = new int[n];


        for (int i = 0; i < n; i++) {

            if(i != 0){
                leftside[i] = leftside[i -1] + A[i];
            }else {
                leftside[i] =  A[i];
            }
        }

        for (int i = n -1; i >= 0; i--) {

            if(i <= n - 2){
                rightside[i] = rightside[i + 1] + A[i];
            }else {
                rightside[i] =  A[i];
            }
        }

        for (int i = 0; i < n; i++) {

            if(leftside[i] == rightside[i]){
                return i;
            }
        }

        return -1;
    }

}
