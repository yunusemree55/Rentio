package car_rental.demo.core.utilities.results;

public class SuccessResult extends Result{

    public SuccessResult(String message) {
        super(true, message);
    }

    public SuccessResult() {
        super(true);
    }
}
