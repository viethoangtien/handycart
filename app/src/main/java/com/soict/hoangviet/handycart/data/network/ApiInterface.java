package com.soict.hoangviet.handycart.data.network;


import com.soict.hoangviet.handycart.base.ListResponse;
import com.soict.hoangviet.handycart.entity.BannerResponse;
import com.soict.hoangviet.handycart.entity.HomeProductResponse;
import com.soict.hoangviet.handycart.entity.SearchResponse;

import java.util.HashMap;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    @GET("search")
    @Headers({"lang: vi", "Content-Type: application/json"})
    Single<ListResponse<SearchResponse>> search(@Query("s") String keyword,
                                                @Query("page") int pageIndex);

    @GET(ApiConstant.BANNER)
    @Headers("Content-Type: application/json")
    Single<BannerResponse> getListBanners();

    @GET(ApiConstant.PRODUCT_CATEGORY)
    @Headers("Content-Type: application/json")
    Single<ListResponse<HomeProductResponse>> getListHomeProduct(@QueryMap HashMap<String, Object> data);
}
