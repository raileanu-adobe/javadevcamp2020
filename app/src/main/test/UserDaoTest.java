import com.adobe.devcamp.dao.AdvertisingDao;
import com.adobe.devcamp.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

    @Mock
    DataSource ds;

    @Mock
    Connection connection;

    @Mock
    Statement statement;

    @Mock
    ResultSet resultSet;

    @Before
    public void setup() throws SQLException {
        User user = new User("Ana","Maria","email", null);

        when(ds.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(statement);

        when(statement.executeQuery(anyString())).thenReturn(resultSet);
        doReturn(true).doReturn(false).when(resultSet).next();
        when(resultSet.getInt(any())).thenReturn(1);
        when(resultSet.getString(any())).thenReturn(user.getFirstName());
    }

    @Test
    public void shouldGetUsers() throws SQLException {
        AdvertisingDao<User> dao = new AdvertisingDao<>(ds);
        final Map<Integer, String> users = dao.selectAll(User.class);
        assertEquals(1, users.size());
    }

}
