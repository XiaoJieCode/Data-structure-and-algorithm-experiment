package MyList.exception;

public class MyListOutBoundException extends RuntimeException{
    public MyListOutBoundException(String message) {
        super(message);
    }
}
