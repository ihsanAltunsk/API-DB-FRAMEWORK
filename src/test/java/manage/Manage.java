package manage;

import lombok.Getter;
@Getter
public class Manage {
    private String queryUS01Q01 = "INSERT INTO cities (id, name, state_id, status, created_at) VALUES(?, ?, ?, ?, ?)";
    private String queryUS01Q02 = "SELECT id FROM cities";
    private String queryUS02Q02 = "SELECT * FROM users WHERE id = ?";
}
