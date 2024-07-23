package com.newtodos.newtodos.Authentication;
public class authenticatoinbean {
    private String message;
    public authenticatoinbean(String message){
        this.message=message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    @Override
    public String toString() {
        return "helloworldbean [message=" + message + "]";
    }


}
