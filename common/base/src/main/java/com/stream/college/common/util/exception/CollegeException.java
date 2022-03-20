package com.stream.college.common.util.exception;

import com.stream.college.common.util.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author stream
 * @since 2022/3/20 15:24
 */
@Data
public class CollegeException extends RuntimeException {

    private Integer code;

    public CollegeException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public CollegeException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
