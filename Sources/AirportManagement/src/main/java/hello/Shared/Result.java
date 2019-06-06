package hello.Shared;

public final class Result {
    private Result(boolean state, String error){
        this.isSuccess = state;
        this.error = error;
    }

    private String error;
    private boolean isSuccess;

    public static Result ok(){
        return new Result(true, "");
    }

    public static Result fail(String error){
        return new Result(false, error);
    }

    public boolean isSuccess(){
        return this.isSuccess;
    }

    public String getError() {
        return error;
    }
}
