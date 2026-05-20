package com.challenge.utils;

public enum WebSiteTest {
    
    URL_DATA_TEST ("https://jsonplaceholder.typicode.com");
    private final String  url;

   WebSiteTest(String url){
    this.url = url;
   }

public String getUrl(){
    return this.url;
}

}
