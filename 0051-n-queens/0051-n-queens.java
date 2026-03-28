class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>(n);
        List<List<String>> ans = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            List<String> OneDBoard = new ArrayList<>(n);
            for(int j=0; j<n; j++){
                OneDBoard.add(".");
            }
            board.add(OneDBoard);
        }
        nQueens(board,0,ans); //0-first row
        return ans;
    }
    public void nQueens(List<List<String>> board, int row, List<List<String>> ans){

        if(row == board.size()) {
            ArrayList<String> temp = new ArrayList<>();
            for(int i=0; i<board.size(); i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<board.size(); j++){
                    sb.append(board.get(i).get(j));
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }

        //place in every col for a single row where suitable
        for(int j=0; j<board.get(row).size(); j++){
            if(isSafe(board, row, j)){
                board.get(row).set(j,"Q");
                nQueens(board,row+1,ans);
                board.get(row).set(j,".");
            }
        }
    }
    private boolean isSafe(List<List<String>> board, int row, int col){
        //check diag-left
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board.get(i).get(j).equals("Q")) return false;
        }
        //vertical up
        for(int i=row-1; i>=0; i--){
            if(board.get(i).get(col).equals("Q")) return false;
        }
        //diag-right
        for(int i=row-1,j=col+1; i>=0 && j<board.size(); i--,j++){
            if(board.get(i).get(j).equals("Q")) return false;
        }
        return true;
    }
}