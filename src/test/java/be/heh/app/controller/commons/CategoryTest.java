package be.heh.app.controller.commons;

import be.heh.app.controller.rest.app.CategoryController;
import be.heh.app.controller.services.app.CategoryService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

//@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryTest {

    /*@Autowired
    MockMvc mvc;

    @MockBean
    CategoryService categoryService;

    @Test
    public void givenCategory_whenGetCategory_thenReturnJsonArray() throws Exception {
        Category category = new Category();
        category.setName("Test");
        category.setDescription("Test2");
        List<Category> categoryList = Arrays.asList(category);

        given(categoryService.getAllCategory()).willReturn(categoryList);

        mvc.perform(get("/api/v1/category")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
                /*.andExpect(jsonPath("$[0].name", is(category.getName()))
    }*/

    @Autowired
    private CategoryService categoryService;

    @Test
    void savedUserHasRegistrationDate() {
        /*CategoryValidator categoryValidator = new CategoryValidator();
        categoryValidator.get
        categoryService.insertCategory()
        User user = new User("zaphod", "zaphod@mail.com");
        User savedUser = registerUseCase.registerUser(user);
        assertThat(savedUser.getRegistrationDate()).isNotNull();*/
    }

}
