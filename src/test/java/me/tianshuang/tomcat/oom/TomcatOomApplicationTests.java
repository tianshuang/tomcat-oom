package me.tianshuang.tomcat.oom;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.junit.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

public class TomcatOomApplicationTests {

    private final static OkHttpClient client = new OkHttpClient().newBuilder()
            .connectTimeout(Duration.ZERO)
            .readTimeout(Duration.ZERO)
            .writeTimeout(Duration.ZERO)
            .build();

    @Test
    public void oomTest() throws IOException {
        char[] chars = new char[200 * 1024 * 1024];
        Arrays.fill(chars, 'P');

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("body", new String(chars))
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:8080/upload")
                .post(requestBody)
                .build();

        client.newCall(request).execute();
    }

}
