package com.yao.demo.form;

public interface FormConvert<S,T> {

    T convert(S s);
}
