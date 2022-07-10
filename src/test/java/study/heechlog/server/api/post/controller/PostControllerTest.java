package study.heechlog.server.api.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import study.heechlog.server.api.post.controller.request.CreatePostRequest;
import study.heechlog.server.core.post.domain.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class PostControllerTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findPost() throws Exception {
        //given
        Post post = Post.createPostBuilder()
                .title("test_title")
                .content("test_content")
                .build();
        em.persist(post);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.get("/api/posts/{postId}", post.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.postId").value(post.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.postTitle").value(post.getTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.postContent").value(post.getContent()))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void savePostTest() throws Exception {
        //given
        CreatePostRequest request = CreatePostRequest.builder()
                .title("제목입니다.")
                .content("내용입니다.")
                .build();

        String json = objectMapper.writeValueAsString(request);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void savePostTest_validation() throws Exception {
        //given
        CreatePostRequest request = CreatePostRequest.builder()
                .title("")
                .content("")
                .build();

        String json = objectMapper.writeValueAsString(request);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("잘못된 요청입니다."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors", hasSize(2)))
                .andDo(MockMvcResultHandlers.print());
    }
}