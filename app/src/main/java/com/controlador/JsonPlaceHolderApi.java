package com.controlador;

import com.modelo.entidad.ProductoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET
    Call<ProductoResponse> getProductos(@Url String url);

    // Aquí puedes añadir los métodos PUT y demás si es necesario
}
