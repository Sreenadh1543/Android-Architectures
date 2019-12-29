package com.example.androidarchitectures.mvp;

import java.util.List;

public interface View {

    void setValues(List<String> countries);

    void onError();
}
