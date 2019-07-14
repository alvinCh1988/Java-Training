package com.yao.demo.valid;

public interface FormConvert<S,T> {

    T convert(S s);
}
