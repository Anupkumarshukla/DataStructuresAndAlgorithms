
public class NumberOfBuildingsFacingTheSun {

    public static void main(String... args){

        int height[] = {1,2,3,4,3,2,1};

        facingSunCount(height,4);
    }

    static void facingSunCount(int height[],int n ){
        int buildingCount = 1;
        int currMaxHeight = height[0];
        for (int i=1;i<=n;i++){
            if(height[i]>currMaxHeight){
                buildingCount = buildingCount + 1;
                currMaxHeight = height[i];
            }
        }
        System.out.print("Number of buildings facing the sun : " + buildingCount);
    }

}
