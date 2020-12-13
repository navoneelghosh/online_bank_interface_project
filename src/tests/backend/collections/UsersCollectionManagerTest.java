package tests.backend.collections;

import com.bank.atm.backend.collections.UsersCollectionManager;
import com.bank.atm.backend.users.Admin;
import com.bank.atm.backend.users.Client;
import com.bank.atm.backend.users.User;
import com.bank.atm.util.ID;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class UsersCollectionManagerTest
 *
 * @author: Nathan Lauer
 * @email: lauern@bu.edu
 * Creation Date: 12/13/20
 * <p>
 * Please feel free to ask me any questions. I hope you're having a nice day!
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsersCollectionManagerTest {
    private final static ID firstId = new ID();
    private final static ID secondId = new ID();
    private final static ID thirdId = new ID();
    private final static List<User> users = new ArrayList<>();

    @BeforeAll
    public static void init() {
        // Create a few users, and store them
        User firstClient = new Client("Nathan", "Lauer", firstId);
        User secondClient = new Client("Danny", "Lauer", secondId);
        User admin = new Admin("Boss", "Man", thirdId);
        users.addAll(Arrays.asList(firstClient, secondClient, admin));

        // Clear the output file
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File(UsersCollectionManager.dataFileName));
        } catch (FileNotFoundException e) {
            // Shouldn't happen
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
    }

    @Test
    @Order(1)
    public void testSaveUsers() {
        // Save each of the Users to disk
        for(User user : UsersCollectionManagerTest.users) {
            try {
                UsersCollectionManager.getInstance().save(user);
            } catch (IOException e) {
                e.printStackTrace();
                fail();
            }
        }
        // Test passes as long as no exceptions are thrown
    }

    @Test
    @Order(2)
    public void testFindUserAndModify() {
        // Find the first user
        User user = UsersCollectionManager.getInstance().find(UsersCollectionManagerTest.firstId);
        assertEquals(user, UsersCollectionManagerTest.users.get(0));

        user.setFirstName("Other");
        user.setLastName("Different");
        try {
            UsersCollectionManager.getInstance().save(user);
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Order(3)
    public void testAll() {
        List<User> allUsers = UsersCollectionManager.getInstance().all();
        assertEquals(UsersCollectionManagerTest.users.size(), allUsers.size());
        for(User user : allUsers) {
            assertTrue(UsersCollectionManagerTest.users.contains(user));
        }
    }
}