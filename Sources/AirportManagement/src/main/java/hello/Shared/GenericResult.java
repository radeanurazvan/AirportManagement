package hello.Shared;

public final class GenericResult<T>{
    private GenericResult(boolean state, T value, String error){
        this.isSuccess = state;
        this.error = error;
        this.value = value;
    }

    private String error;
    private boolean isSuccess;
    private T value;

    public static <T> GenericResult<T> ok(T value){
        return new GenericResult<>(true, value, "");
    }

    public static <T> GenericResult<T> fail(String error){
        return new GenericResult<>(false, null, error);
    }

    public boolean isSuccess(){
        return this.isSuccess;
    }

    public T getValue() {
        return this.value;
    }

    public String getError() {
        return error;
    }
}
