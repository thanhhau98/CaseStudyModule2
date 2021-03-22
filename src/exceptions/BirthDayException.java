package exceptions;

public class BirthDayException extends Exception {

    public BirthDayException(){
        super("Birth day >1900, less than current year is 18 year and format: dd/mm/yyyy.");
    }
}
