package exceptions;

public class IdCardException extends Exception {

    public IdCardException(){
        super("Id card must be 9 digit and format: XXX XXX XXX.");
    }
}
