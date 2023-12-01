package org.softuni.mobilele.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softuni.mobilele.models.entities.OfferEntity;
import org.softuni.mobilele.models.entities.UserEntity;
import org.softuni.mobilele.testUtils.TestDataUtil;
import org.softuni.mobilele.testUtils.UserTestDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OfferControllerTestIT {

    private static final String TEST_USER_OWNER = "testUserOwner@example.com";

    private static final String TEST_USER_NON_OWNER = "testUserNonOwner@example.com";

    private static final String TEST_ADMIN_EMAIL = "testAdmin@example.com";

    @Autowired
    private UserTestDataUtil userTestDataUtil;

    @Autowired
    private TestDataUtil testDataUtil;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        testDataUtil.cleanUp();
        userTestDataUtil.cleanUp();
    }

    @AfterEach
    void tearDown() {
        testDataUtil.cleanUp();
        userTestDataUtil.cleanUp();
    }

    @Test
    void testAnonymousDeletionFails() throws Exception {
        UserEntity owner = userTestDataUtil.createTestUser(TEST_USER_OWNER);
        OfferEntity offerEntity = testDataUtil.createTestOffer(owner);

        mockMvc.perform(
                delete("/offer/{uuid}", offerEntity.getUuid())
                        .with(csrf())
        ).andExpect(
                status().is3xxRedirection()
        ).andExpect(redirectedUrlPattern("**/users/login"));
    }

    @Test
    @WithMockUser(username = TEST_USER_OWNER)
    void testNonAdminUserOwnedOffer() throws Exception {
        UserEntity owner = userTestDataUtil.createTestUser(TEST_USER_OWNER);
        OfferEntity offerEntity = testDataUtil.createTestOffer(owner);

        mockMvc.perform(
                delete("/offer/{uuid}", offerEntity.getUuid())
                        .with(csrf())
        ).andExpect(
                status().is3xxRedirection()
        ).andExpect(view().name("redirect:/offers/all"));
    }

    @Test
    @WithMockUser(username = TEST_USER_NON_OWNER)
    void testNonAdminUserNotOwnedOffer() throws Exception {
        userTestDataUtil.createTestUser(TEST_USER_NON_OWNER);

        UserEntity owner = userTestDataUtil.createTestUser(TEST_USER_OWNER);
        OfferEntity offerEntity = testDataUtil.createTestOffer(owner);

        mockMvc.perform(
                delete("/offer/{uuid}", offerEntity.getUuid())
                        .with(csrf())
        ).andExpect(
                status().isForbidden()
        );
    }

    @Test
    @WithMockUser(username = TEST_ADMIN_EMAIL, roles = {"USER", "ADMIN"})
    void testAdminUserNotOwnedOffer() throws Exception {
        userTestDataUtil.createTestAdmin(TEST_ADMIN_EMAIL);
        UserEntity owner = userTestDataUtil.createTestUser(TEST_USER_OWNER);
        OfferEntity offerEntity = testDataUtil.createTestOffer(owner);

        mockMvc.perform(
                delete("/offer/{uuid}", offerEntity.getUuid())
                        .with(csrf())
        ).andExpect(
                status().is3xxRedirection()
        ).andExpect(view().name("redirect:/offers/all"));
    }
}
