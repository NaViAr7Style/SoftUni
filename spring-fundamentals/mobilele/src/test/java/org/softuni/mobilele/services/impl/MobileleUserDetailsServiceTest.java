package org.softuni.mobilele.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.softuni.mobilele.models.entities.UserEntity;
import org.softuni.mobilele.models.entities.UserRoleEntity;
import org.softuni.mobilele.models.enums.UserRoleEnum;
import org.softuni.mobilele.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MobileleUserDetailsServiceTest {

    private MobileleUserDetailsService serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new MobileleUserDetailsService(mockUserRepository);
    }

    @Test
    void testLoadUserByUsernameUserNotFound() {

        assertThrows(
                UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("test_email@test.com")
        );
    }

    @Test
    void testLoadUserByUsernameUserFoundException() {
        // Arrange
        UserEntity testUser = createTestUser();

        when(mockUserRepository.findByEmail(testUser.getEmail()))
                .thenReturn(Optional.of(testUser));

        // Act
        UserDetails userDetails = serviceToTest.loadUserByUsername(testUser.getEmail());

        // Assert
        assertNotNull(userDetails);
        assertEquals(testUser.getEmail(), userDetails.getUsername(), "Username is not mapped to email.");
        assertEquals(testUser.getPassword(), userDetails.getPassword());
        assertEquals(2, userDetails.getAuthorities().size());

        assertTrue(
                containsAuthority(
                        userDetails,
                        "ROLE_" + UserRoleEnum.ADMIN
                ),
                "The user is not admin"
        );

        assertTrue(
                containsAuthority(
                        userDetails,
                        "ROLE_" + UserRoleEnum.USER
                ),
                "The user is not user"
        );

    }

    private boolean containsAuthority(UserDetails userDetails, String expectedAuthority) {
        return userDetails
                .getAuthorities()
                .stream()
                .anyMatch(authority -> expectedAuthority.equals(authority.getAuthority()));
    }

    private static UserEntity createTestUser() {
        UserEntity user = new UserEntity();

        UserRoleEntity adminRole = new UserRoleEntity();
        adminRole.setRole(UserRoleEnum.ADMIN);

        UserRoleEntity userRole = new UserRoleEntity();
        userRole.setRole(UserRoleEnum.USER);

        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setEmail("test_email@test.com");
        user.setPassword("topsecret");
        user.setActive(false);
        user.setRoles(List.of(adminRole, userRole));

        return user;
    }
}
