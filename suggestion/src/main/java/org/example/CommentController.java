package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @GetMapping("/suggestion")
    public Map<String, Object> getSuggestion() {
        Map<String, Object> response = new HashMap<>();
        StringBuilder allComments = new StringBuilder();
        String customText = "根据用户评论内容分三个方面给我改进意见，一：基于所有评论整体分析，二：从菜品方面给出改进意见，三：从服务方面给出改进意见"; // 自定义文本

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT content FROM tb_comment WHERE is_delete = 'n'")) {
            while (rs.next()) {
                allComments.append(rs.getString("content")).append(" ");
            }

            // 构建完整的 prompt，包括评论内容和自定义文本
            String prompt = allComments.toString() + " " + customText;

            OpenAIExample openAIExample = new OpenAIExample();
            String analysisResult = openAIExample.callOpenAI(prompt);

            response.put("code", 0);
            Map<String, String> data = new HashMap<>();
            data.put("suggestion_text", analysisResult);
            response.put("data", data);
        } catch (Exception e) {
            response.put("code", 1);
            response.put("message", "Error fetching suggestion: " + e.getMessage());
        }
        return response;
    }

    @PostMapping("/list")
    public Map<String, Object> getCommentList() {
        Map<String, Object> response = new HashMap<>();
        List<Map<String, Object>> commentList = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tb_comment")) {
            while (rs.next()) {
                Map<String, Object> comment = new HashMap<>();
                comment.put("id", rs.getInt("id"));
                comment.put("userId", rs.getInt("user_id"));
                comment.put("orderNum", rs.getString("order_num"));
                comment.put("serviceScore", rs.getInt("service_score"));
                comment.put("environmentScore", rs.getInt("environment_score"));
                comment.put("tasteScore", rs.getInt("taste_score"));
                comment.put("content", rs.getString("content"));
                comment.put("reply", rs.getString("reply"));
                comment.put("isReply", rs.getString("is_reply"));
                comment.put("replyTime", rs.getTimestamp("reply_time"));
                comment.put("createTime", rs.getTimestamp("create_time"));
                comment.put("updateTime", rs.getTimestamp("update_time"));
                comment.put("isDelete", rs.getString("is_delete"));
                commentList.add(comment);
            }
            response.put("code", 0);
            Map<String, Object> data = new HashMap<>();
            data.put("total", commentList.size());
            data.put("data", commentList);
            response.put("data", data);
        } catch (Exception e) {
            response.put("code", 1);
            response.put("message", "Error fetching comments: " + e.getMessage());
        }
        return response;
    }
}
