import java.util.List;

/**
 * Created by Hakim on 10/23/15.
 */

class Piece{
    List<Edge> edges;   // can be reordered so as to change the orientation

    public void reorderEdges(){};   // reoriente the edges (ie rotate the piece)
    public boolean isCorner(){};
    public void makePiecesMatchAccordingToEdge(Piece other, Edge edgeToMatch){};
}

class Edge{
    int shape;  // 0: flat
                // 1: inner
                // 2: outer
    Piece belongsTo;

    public boolean fitsWith(Edge other){};
}

class Puzzle{
    List<Piece> piecesToPlace;  // initially all of them
    Piece[][] solution; // placed pieces
    int N;
    int numRemainingCorners;
    int numRemainingEdgePieces; // has 1 flat edge

    public void removePieceFromPiecesToPlace(Piece piece){};
    public void solve(){
        // place the next piece that can be placed in the row, or the first piece in the row below
        for (int row=0; row<N; row++){
            for (int col=0; col<N; col++){
                if (piecesToPlace.get(row).isCorner()){
                    // place the first corner we find on the top left
                    solution[0][0] = piecesToPlace.get(row);
                    removePieceFromPiecesToPlace(piecesToPlace.get(row));
                }
                else{
                    // if first column, find the piece that can be placed on the left of the next row
                    if (col == 0){
                        // find a piece which has the edge completing the bottom of the current pice

                    }
                    else{
                        // complete the current row
                        // find the piece that has the edge that completes the right edge of the current piece
                        // return false if no such piece is found and the solution can't be completed
                    }
                }

            }
        }
    }
}

public class Solution06 {
}
