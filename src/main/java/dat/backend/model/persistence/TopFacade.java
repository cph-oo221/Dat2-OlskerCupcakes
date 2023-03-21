package dat.backend.model.persistence;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Top;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;

public class TopFacade {

    public static Top getTop(String name, ConnectionPool connectionPool) throws DatabaseException, SQLException {
        return TopMapper.getTop(name, connectionPool);
    }
}