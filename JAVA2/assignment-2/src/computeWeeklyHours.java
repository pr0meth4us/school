
public class computeWeeklyHours {
    public static int sumHours(int[][] weeklyHours, int employeeIndex){
        int sum = 0;
        for (int i = 0; i <weeklyHours[employeeIndex].length; i ++){
            sum += weeklyHours[employeeIndex][i];
        }
        return sum;
    }



    public static void main(String[] args) {
        int[][] weeklyHours ={
                {2,4,3,4,5,8,8},
                {7,3,4,3,3,4,4},
                {3,3,4,3,3,2,2},
                {9,3,4,7,3,4,1},
                {3,5,4,3,6,3,8},
                {3,4,4,6,3,4,4},
                {3,7,4,8,3,8,4},
                {6,3,5,9,2,7,9}
        };
        for (int i = 0; i<weeklyHours.length; i++){
            System.out.println("Employee " + i + " worked " + sumHours(weeklyHours, i) + " hours this week.");
        }

    }



}
