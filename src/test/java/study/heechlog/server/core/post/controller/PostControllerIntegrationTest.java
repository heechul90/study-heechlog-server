package study.heechlog.server.core.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import study.heechlog.server.annotation.CustomMockSecurityContext;
import study.heechlog.server.core.post.controller.request.CreatePostRequest;
import study.heechlog.server.core.post.controller.request.UpdatePostRequest;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.repository.PostRepository;
import study.heechlog.server.core.user.domain.User;
import study.heechlog.server.core.user.repository.UserRepository;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional
class PostControllerIntegrationTest {

    public static final String TITLE = "test_title1";
    public static final String CONTENT = "test_content1";

    @PersistenceContext private EntityManager em;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private MockMvc mockMvc;
    @Autowired private PostRepository postRepository;
    @Autowired private UserRepository userRepository;

    @AfterEach
    void clean() {
        postRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    @CustomMockSecurityContext(email = "heechman@naver.com")
    @DisplayName("게시글 목록 조회")
    void findPostsTest() throws Exception {
        //given
        User findUser = userRepository.findByEmail("heechman@naver.com").get();

        Post post1 = getPost(TITLE, CONTENT, findUser);
        Post post2 = getPost("test_title2", "test_content2", findUser);
        em.persist(post1);
        em.persist(post2);

        //expected
        mockMvc.perform((MockMvcRequestBuilders.get("/api/posts"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.length()", is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].postId").value(post2.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].postTitle").value(post2.getTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].postContent").value(post2.getContent()))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @CustomMockSecurityContext(email = "heechman@naver.com")
    @DisplayName("게시글 단건 조회")
    void findPostTest() throws Exception {
        //given
        User findUser = userRepository.findByEmail("heechman@naver.com").get();

        Post post = getPost("test_title", "test_content", findUser);
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
    @CustomMockSecurityContext(email = "heechman@naver.com")
    @DisplayName("게시글 단건 조회_예외 발생")
    void findPostTest_validation() throws Exception {
        //given
        User findUser = userRepository.findByEmail("heechman@naver.com").get();

        Post post = getPost("test_title", "test_content", findUser);
        em.persist(post);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.get("/api/posts/{postId}", post.getId() + 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.NOT_FOUND.name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("존재하지 않는 게시글입니다."))
                .andDo(MockMvcResultHandlers.print());
    }

    @DisplayName("게시글 저장")
    @CustomMockSecurityContext
    @Test
    void savePostTest() throws Exception {
        //given
        CreatePostRequest request = new CreatePostRequest();
        request.setTitle("제목입니다.");
        request.setContent("내용입니다.");

        String json = objectMapper.writeValueAsString(request);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @DisplayName("게시글 저장_예외 발생_필드")
    @CustomMockSecurityContext
    @Test
    void savePostTest_validation_field() throws Exception {
        //given
        CreatePostRequest request = new CreatePostRequest();
        request.setTitle("");
        request.setContent("");

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

    @DisplayName("게시글 저장_예외 발생_제목")
    @CustomMockSecurityContext
    @Test
    void savePostTest_validation_object_title() throws Exception {
        //given
        CreatePostRequest request = new CreatePostRequest();
        request.setTitle("바보");
        request.setContent("내용");

        String json = objectMapper.writeValueAsString(request);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/api/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.BAD_REQUEST.name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("잘못된 요청입니다."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[0].fieldName").value("title"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[0].errorMessage").value("제목에 바보를 포함할 수 없습니다."))
                .andDo(MockMvcResultHandlers.print());
    }

    @DisplayName("게시글 저장_예외 발생_내용")
    @CustomMockSecurityContext
    @Test
    void savePostTest_validation_object_content() throws Exception {
        //given
        CreatePostRequest request = new CreatePostRequest();
        request.setTitle("제목");
        request.setContent("멍청이");

        String json = objectMapper.writeValueAsString(request);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.BAD_REQUEST.name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("잘못된 요청입니다."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[0].fieldName").value("content"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[0].errorMessage").value("내용에 멍청이를 포함할 수 없습니다."))
                .andDo(MockMvcResultHandlers.print());
    }

    @DisplayName("게시글 수정")
    @CustomMockSecurityContext(email = "heechman@naver.com")
    @Test
    void updatePostTest() throws Exception {
        //given
        User findUser = userRepository.findByEmail("heechman@naver.com").get();

        Post post = getPost("title", "content", findUser);
        em.persist(post);

        UpdatePostRequest request = new UpdatePostRequest();
        request.setPostTitle("update_title");
        request.setPostContent("update_content");

        String json = objectMapper.writeValueAsString(request);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.put("/api/posts/{postId}", post.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.OK.name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.updatedPostId").value(post.getId()))
                .andDo(MockMvcResultHandlers.print());
    }

    @DisplayName("게시글 수정_예외 발생")
    @CustomMockSecurityContext(email = "heechman@naver.com")
    @Test
    void updatePostTest_validation() throws Exception {
        //given
        User findUser = userRepository.findByEmail("heechman@naver.com").get();

        Post post = getPost("title", "content", findUser);
        em.persist(post);

        UpdatePostRequest request = new UpdatePostRequest();
        request.setPostTitle("update_title");
        request.setPostContent("update_content");

        String json = objectMapper.writeValueAsString(request);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.put("/api/posts/{postId}", post.getId() + 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.NOT_FOUND.name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("존재하지 않는 게시글입니다."))
                .andDo(MockMvcResultHandlers.print());
    }

    @DisplayName("게시글 삭제")
    @CustomMockSecurityContext(email = "heechman@naver.com")
    @Test
    void deletePostTest() throws Exception {
        //given
        User findUser = userRepository.findByEmail("heechman@naver.com").get();

        Post post = getPost("title", "content", findUser);
        em.persist(post);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/posts/{postId}", post.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.OK.name()))
                .andDo(MockMvcResultHandlers.print());
    }

    @DisplayName("게시글 삭제_예외 발생")
    @CustomMockSecurityContext(email = "heechman@naver.com")
    @Test
    void deletePostTest_validation() throws Exception {
        //given
        User findUser = userRepository.findByEmail("heechman@naver.com").get();

        Post post = getPost("title", "content", findUser);
        em.persist(post);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/posts/{postId}", post.getId() + 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.NOT_FOUND.name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("존재하지 않는 게시글입니다."))
                .andDo(MockMvcResultHandlers.print());
    }

    private Post getPost(String title, String content, User user) {
        return Post.createPostBuilder()
                .title(title)
                .content(content)
                .user(user)
                .build();
    }
}