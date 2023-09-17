package com.productosisis.interfaces;

import com.productosisis.model.Account;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountApi {
    @POST("api/accounts")
    Call<Account> registerData(@Body Account a);
}
