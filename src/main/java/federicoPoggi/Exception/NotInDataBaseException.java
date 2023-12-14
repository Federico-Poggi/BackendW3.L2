package federicoPoggi.Exception;


public class NotInDataBaseException extends Exception  {
    public NotInDataBaseException(){};
    public  NotInDataBaseException(String message){
        super(message);
    }
}
