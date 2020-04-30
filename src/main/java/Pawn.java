public class Pawn extends Figure{
    public Pawn(FigureColor figureColor){
        super(figureColor);
    }
    @Override
    public String toString(){
        return this.getFigureColor() + "P";
    }
}
