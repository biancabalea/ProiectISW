package managamentHR.employee.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Could not found the employee with id "+ id);
    }
}
