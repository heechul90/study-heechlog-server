package study.heechlog.server.api.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.service.PostService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebMvcTest(PostController.class)
class PostControllerTest {

    //POST DATA
    public static final String TITLE = "test_title";
    public static final String CONTENT = "test_content";

    //POST UPDATE DATA
    public static final String UPDATE_TITLE = "update_title";
    public static final String UPDATE_CONTENT = "update_content";
    public static final String API_FIND_POST = "/api/posts/{postId}";

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


    }

    @Test
    @DisplayName("게시글 단건 조회")
    void findPostTest() throws Exception {
        //given
        Post post = getPost(TITLE, CONTENT);
        given(postService.findPost(any())).willReturn(post);

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(API_FIND_POST, any(Long.class))
                .contentType(MediaType.APPLICATION_JSON)
        );

        //then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.postTitle").value(TITLE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.postContent").value(CONTENT))
                .andDo(MockMvcResultHandlers.print());

        //verify
        verify(postService, times(1)).findPost(any());
    }

    @Test
    @DisplayName("게시글 단건 조회_예외 발생")
    void findPostTest_validation() throws Exception {
        //given

        //when

        //then

        //verify

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