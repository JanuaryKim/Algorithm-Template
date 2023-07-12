class Solution {
    public int[] solution(int brown, int yellow) {

        // bh = yh + 2
        // bw = yw + 2
        // brown = bh * bw
        // yellow = (bh * bw) - (bh * 2) - (bw * 2) + 4
        //   2     =  (3 * 4) - (3 * 2) - (4 * 2) + 4
        //               12 - 6 - 8 + 4   
        int[] result = new int[0];
        int total = brown + yellow;

        for(int width = 3; width <= total / 3; width++)
        {
            if(total % width == 0)
            {
                int height = total / width;
                if(height <= width)
                {
                    if(yellow == ((height * width) - (height * 2) - (width * 2) + 4))
                    {
                        result = new int[]{width, height};
                        return result;
                    }
                }
            }
        }

        return result;

    }
}