//The Blocker: I was trying to calculate the dates by taking 2 array for both alice and bob seperate and then count min of each but 
//it is too complicated to calculate. then I took help from hints which shows to traverse all 365 date.

//So I traverse all 365 date.

class Solution {
    public int countDaysTogether(String aA, String lA, String aB, String lB) {
        int[] daysPrefixSum = {0,31,59,90,120,151,181,212,243,273,304,334,365};
        int aliceStartDay = dayCal(aA,daysPrefixSum);
        int aliceEndDay = dayCal(lA, daysPrefixSum);
        int bobStartDay = dayCal(aB, daysPrefixSum);
        int bobEndDay = dayCal(lB, daysPrefixSum);
        System.out.println(aliceStartDay);
        System.out.println(aliceEndDay);
        System.out.println(bobStartDay);
        System.out.println(bobEndDay);
        int count = 0;
        for(int i=aliceStartDay; i<= aliceEndDay; i++){
            if(i>=bobStartDay && i<= bobEndDay) count++;
        }
        return count;
    }
    public int dayCal(String s, int[] arr){
        return arr[(s.charAt(0)-'0')*10 + s.charAt(1)-'0' - 1]+(s.charAt(3)-'0')*10 + s.charAt(4)-'0';
    }
}
