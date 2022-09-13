package study.heechlog.server.api.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import study.heechlog.server.api.post.controller.request.CreatePostRequest;
import study.heechlog.server.api.post.controller.request.UpdatePostRequest;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.service.PostService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@WebMvcTest(PostController.class)
class PostControllerTest {

    //POST DATA
    public static final String TITLE = "test_title";
    public static final String CONTENT = "test_content";

    //POST UPDATE DATA
    public static final String UPDATE_TITLE = "update_title";
    public static final String UPDATE_CONTENT = "update_content";

    @Autowired private MockMvc mockMvc;

    @MockBean private PostService postService;

    @Autowired private ObjectMapper objectMapper;


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
        Post post1 = getPost(TITLE, CONTENT);
        Post post2 = getPost("test_title2", "test_content2");
        em.persist(post1);
        em.persist(post2);

        //expected
        mockMvc.perform((MockMvcRequestBuilders.get("/api/posts"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.length()", is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].postId").value(post1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].postTitle").value(post1.getTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].postContent").value(post1.getContent()))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("게시글 단건 조회")
    void findPostTest() throws Exception {
        //given

        //when

        //then

        //verify
    }

    @Test
    @DisplayName("게시글 단건 조회_예외 발생")
    void findPostTest_validation() throws Exception {
        //given

    }

    @Test
    @DisplayName("게시글 저장")
    void savePostTest() throws Exception {
        //given

    }

    @Test
    @DisplayName("게시글 저장_예외 발생_필드")
    void savePostTest_validation_field() throws Exception {
        //given

    }

    @Test
    @DisplayName("게시글 저장_예외 발생_제목")
    void savePostTest_validation_object_title() throws Exception {
        //given

    }

    @Test
    @DisplayName("게시글 저장_예외 발생_내용")
    void savePostTest_validation_object_content() throws Exception {
        //given

    }

    @Test
    @DisplayName("게시글 수정")
    void updatePostTest() throws Exception {
        //given

    }

    @Test
    @DisplayName("게시글 수정_예외 발생")
    void updatePostTest_validation() throws Exception {
        //given

    }

    @Test
    @DisplayName("게시글 삭제")
    void deletePostTest() throws Exception {
        //given

    }

    @Test
    @DisplayName("게시글 삭제_예외 발생")
    void deletePostTest_validation() throws Exception {
        //given

    }
}