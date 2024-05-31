package org.example;

import okhttp3.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class OpenAIExample {

    private static final String API_KEY = "sk-D57Y4KeEggfY0tK63f1eC89e26194bB6Ab4d4f17Fc91E3Ab";  // 替换为你的实际API密钥
    private static final String OPENAI_API_URL = "https://api.xiaoai.plus/v1/chat/completions";  // 确保使用正确的端点

    private OkHttpClient client;
    private ObjectMapper objectMapper;

    public OpenAIExample() {
        this.client = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public String callOpenAI(String prompt) throws IOException {
        // 构建JSON请求体
        String json = "{"
                + "\"model\": \"gpt-3.5-turbo\","
                + "\"messages\": [{\"role\": \"user\", \"content\": \"" + prompt.replace("\n", "\\n").replace("\"", "\\\"") + "\"}],"
                + "\"max_tokens\": 500"
                + "}";

        // 打印请求体
        System.out.println("Request JSON: " + json);

        // 构建请求体
        RequestBody body = RequestBody.create(
                json, MediaType.get("application/json; charset=utf-8"));

        // 构建请求
        Request request = new Request.Builder()
                .url(OPENAI_API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        System.out.println("Request URL: " + request.url());
        System.out.println("Authorization Header: " + request.header("Authorization"));

        int retries = 10;  // 设置重试次数
        int delay = 15000; // 设置初始等待时间为15秒
        while (retries > 0) {
            try (Response response = client.newCall(request).execute()) {
                if (response.code() == 429) {
                    retries--;
                    Thread.sleep(delay);  // 等待后重试
                    delay *= 2;  // 增加等待时间以指数级递增
                } else if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    // 解析响应
                    String responseBody = response.body().string();
                    JsonNode jsonNode = objectMapper.readTree(responseBody);
                    return jsonNode.get("choices").get(0).get("message").get("content").asText();
                }
            } catch (InterruptedException e) {
                throw new IOException("Interrupted while waiting to retry", e);
            }
        }
        throw new IOException("Exceeded maximum retries due to rate limits");
    }
}
