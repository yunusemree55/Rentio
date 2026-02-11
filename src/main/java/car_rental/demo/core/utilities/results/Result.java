package car_rental.demo.core.utilities.results;

import lombok.Getter;

@Getter
public abstract class Result {

    private boolean isSuccess;
    private String message;

    public Result(boolean isSuccess,String message){
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public Result(boolean isSuccess){
        this.isSuccess = isSuccess;
    }


}
