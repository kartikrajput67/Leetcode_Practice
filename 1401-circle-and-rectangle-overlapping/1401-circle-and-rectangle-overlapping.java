class Solution {
    public boolean checkOverlap(int r, int x, int y, int x1, int y1, int x2, int y2) {
        int xi;
        int yi;
        if(x1 > x) xi = x1;
        else if(x2 < x) xi = x2;
        else xi = x;

        if(y1 > y) yi = y1;
        else if(y2 < y) yi = y2;
        else yi = y;

        //(xi,yi) --------> (x,y)
        int dis = (int)Math.sqrt((xi-x)*(xi-x) + (yi-y)* (yi-y));
        return dis <= r;

    }
}