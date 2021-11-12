package cn.bngel.rcty.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult <T>{

    public static final Integer SUCCESS_CODE = 200;
    public static final Integer FAILURE_CODE = 400;

    private Integer code;
    private T data;
    private String message;

    public static CommonResult getSuccessResult() {
        return new CommonResult(SUCCESS_CODE, null, "success");
    }

    public static CommonResult getFailureResult() {
        return new CommonResult(FAILURE_CODE, null, "failure");
    }
}
