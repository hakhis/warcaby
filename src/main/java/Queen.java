public class Queen extends Figure {
    public Queen(FigureColor figureColor){
        super(figureColor);
    }
    @Override
    public String toString(){
        return this.getFigureColor() + "Q";
    }
}
