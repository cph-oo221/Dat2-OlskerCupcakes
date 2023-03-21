package dat.backend.model.persistence;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Top;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

public class TopFacade {

    public static Top getTop(String name, ConnectionPool connectionPool) throws DatabaseException {
        return TopMapper.getTop(name, connectionPool);
    }
}