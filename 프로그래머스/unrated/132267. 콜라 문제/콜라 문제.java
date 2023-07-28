class Solution {
    public int solution(int a, int b, int n) {
        
        int result = 0;
        int haveCoke = n; //20
        while(haveCoke >= a)
        {
            int given = 0;
            while(haveCoke >= a) 
            {
                haveCoke -= a; 
                given += b; 
            }
            
            result += given; 
            haveCoke += given; 
        }
        
        return result;
    }
}