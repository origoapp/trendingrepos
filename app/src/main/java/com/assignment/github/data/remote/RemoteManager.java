package com.assignment.github.data.remote;

import java.util.Map;

import com.assignment.github.data.model.RepoModel;
import com.assignment.github.data.remote.rest.RestApi;
import com.assignment.github.data.remote.rest.RestClient;
import io.reactivex.Observable;

public class RemoteManager {
    private static RemoteManager mInstance = null;

    private RemoteManager(){}

    public static RemoteManager getInstance(){
        return mInstance == null ? mInstance= new RemoteManager() : mInstance;
    }

    public Observable<RepoModel> getRepos(Map<String, String> map){
        RestApi api = RestClient.getApiService();
        return api.getRepos(map);
    }
}
