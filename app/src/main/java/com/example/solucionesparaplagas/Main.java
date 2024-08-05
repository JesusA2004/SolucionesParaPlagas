package com.example.solucionesparaplagas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.modelo.entidad.Producto;
import com.modelo.entidad.ProductoResponse;
import com.controlador.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.ArrayList;
import java.util.List;

public class Main extends Activity {

	private TextView mJsonTxtView;
	private List<Producto> listaProductos = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.productos);
		mJsonTxtView = findViewById(R.id.jsonText);
		getProductos("Products"); // Llamar al método con la URL inicial
	}

	private void getProductos(String endpoint) {
		// Crea un cliente OkHttp con el interceptor
		OkHttpClient okHttpClient = new OkHttpClient.Builder()
				.addInterceptor(chain -> {
					Request originalRequest = chain.request();
					Request.Builder requestBuilder = originalRequest.newBuilder()
							.addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImFkbWlufDEyMTU4MCIsIkludGVybmFsSUQiOiJhZjYwNTczZS0zNDhjLTQxMzEtYjBiMi00ZDY4ZWMwM2U4YTAiLCJuYmYiOjE3MjE4NjE0NjIsImV4cCI6MTc1MzM5NzQ2MiwiaWF0IjoxNzIxODYxNDYyLCJpc3MiOiJNaW5udF9Tb2x1dGlvbnNfU0FfREVfQ1YiLCJhdWQiOiJCaW5kX0VSUF9BUElfVXNlcnMifQ.1DqPMprCYYcMrh2DLl6FMozNzzkfQchUd5nHWhSQAyg");
					Request newRequest = requestBuilder.build();
					return chain.proceed(newRequest);
				})
				.build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.bind.com.mx/api/")
				.client(okHttpClient) // Usa el cliente OkHttp con el interceptor
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

		Call<ProductoResponse> call = jsonPlaceHolderApi.getProductos(endpoint);
		call.enqueue(new Callback<ProductoResponse>() {
			@Override
			public void onResponse(Call<ProductoResponse> call, Response<ProductoResponse> response) {
				if (!response.isSuccessful()) {
					mJsonTxtView.setText("Código: " + response.code());
					return;
				}
				ProductoResponse productoResponse = response.body();
				if (productoResponse != null) {
					listaProductos.addAll(productoResponse.getValue());
					for (Producto producto : productoResponse.getValue()) {
						String contenido = "";
						contenido += "Title: " + producto.getTitle() + "\n";
						contenido += "Description: " + producto.getDescription() + "\n";
						contenido += "Unit: " + producto.getUnit() + "\n";
						contenido += "Type: " + producto.getType() + "\n";
						contenido += "Weight: " + producto.getWeight() + "\n\n";
						mJsonTxtView.append(contenido);
					}

					// Verificar si hay más productos para obtener
					String nextLink = productoResponse.getNextLink();
					if (nextLink != null && !nextLink.isEmpty()) {
						getProductos(nextLink); // Llamar al método recursivamente con el nextLink
					}
				}
			}

			@Override
			public void onFailure(Call<ProductoResponse> call, Throwable t) {
				mJsonTxtView.setText(t.getMessage());
			}
		});
	}
}
