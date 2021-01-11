package be.heh.app.controller;

import be.heh.app.controller.commons.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ControllerTest extends AbstractControllerTest {

    @Test
    public void contextLoads() throws Exception {
        assertThat(categoryController).isNotNull();
    }

}
