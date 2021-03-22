package exceptions;

public class GenderException extends Exception {

    public GenderException(){
        super("Fender must be Male, Female or Unknown.");
    }
}
