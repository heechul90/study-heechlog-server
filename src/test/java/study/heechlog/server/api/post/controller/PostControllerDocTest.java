package study.heechlog.server.api.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.snippet.Attributes;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import study.heechlog.server.api.post.controller.request.CreatePostRequest;
import study.heechlog.server.core.post.domain.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "api.heechlog.com", uriPort = 443)
@Transactional
public class PostControllerDocTest {

    @PersistenceContext EntityManager em;

    @Autowired private ObjectMapper objectMapper;

    @Autowired private MockMvc mockMvc;

    private Post getPost(String title, String content) {
        Post post = Post.createPostBuilder()
                .title(title)
                .content(content)
                .build();
        return post;
    }

    @Test
    @DisplayName("게시글 목록 조회")
    void findPostsTest() throws Exception {
        //given
        Post post = getPost("test_title", "test_content");
        em.persist(post);

        //expected
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/posts/{postId}", post.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andDo(document("post-inquiry",
                        pathParameters(
                                parameterWithName("postId").description("게시글 ID")
                        ),
                        responseFields(
                                fieldWithPath("status").description("상태"),
                                fieldWithPath("message").description("메시지"),
                                fieldWithPath("errors").description("에러 목록"),
                                fieldWithPath("data.postId").description("게시글 ID"),
                                fieldWithPath("data.postTitle").description("제목"),
                                fieldWithPath("data.postContent").description("내용")
                        )
                ));
    }

    @Test
    @DisplayName("게시글 저장")
    void savePostTest() throws Exception {
        //given
        CreatePostRequest request = new CreatePostRequest();
        request.setTitle("제목입니다.");
        request.setContent("내용입니다.");

        String json = objectMapper.writeValueAsString(request);

        //expected
        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andDo(document("post-create",
                        requestFields(
                                fieldWithPath ("title").description("제목")
                                        .attributes(Attributes.key("constraints").value("좋은 제목 입력해주세요.")),
                                fieldWithPath("content").description("내용").optional()
                        ))
                );
    }
}
