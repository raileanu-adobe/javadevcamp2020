import com.adobe.devcamp.dao.AdvertisingDao;
import com.adobe.devcamp.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.jws.soap.SOAPBinding;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {
    @Mock
    DataSource ds;

    @Mock
    Connection connection;

    @Mock
    Statement statement;

    @Mock
    ResultSet rs;

    private User user;

    @Before
    public void setup() throws SQLException {
        user = new User("Ana", "Maria", "email", null);

        Mockito.when(ds.getConnection()).thenReturn(connection);
        Mockito.when(connection.createStatement()).thenReturn(statement);

        Mockito.when(statement.executeQuery(Matchers.anyString())).thenReturn(rs);

        Mockito.doReturn(true).doReturn(false).when(rs).next();
        Mockito.when(rs.getInt(Matchers.any())).thenReturn(1);
        Mockito.when(rs.getString(Matchers.any())).thenReturn(user.getFirstName());
    }

    @Test
    public void shouldGetUsers() throws SQLException {
        AdvertisingDao<User> dao = new AdvertisingDao<>(ds);
        final Map<Integer, String> users = dao.selectAll(User.class);
        assertEquals(1, users.size());
    }
}
