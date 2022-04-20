package com.drs.mes.result;

    import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code , String message){
        this(code,message,null);
    }

    public CommonResult(Integer code , String message , Object o){
        this.code = code;
        this.message = message;
        this.data = (T)o;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
