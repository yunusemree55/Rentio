package car_rental.demo.core.utilities.results;

import lombok.Getter;

@Getter
public abstract class DataResult<T> extends Result {

    private T data;

    public DataResult(T data, boolean isSuccess, String message) {
        super(isSuccess, message);
        this.data = data;
    }

    public DataResult(T data, boolean isSuccess) {
        super(isSuccess);
        this.data = data;
    }



}
