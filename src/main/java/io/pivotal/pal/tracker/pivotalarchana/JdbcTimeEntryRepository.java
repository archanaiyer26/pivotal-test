package io.pivotal.pal.tracker.pivotalarchana;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
public class JdbcTimeEntryRepository implements  TimeEntryRepository {

    public JdbcTimeEntryRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private JdbcTemplate jdbcTemplate;


    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        KeyHolder generatorKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement("insert into time_entries(project_id, user_id, date,hours) " +
                    "values (?,?,?,?)",RETURN_GENERATED_KEYS);
            statement.setLong(1,timeEntry.getProjectID());
            statement.setLong(2,timeEntry.getUserID());
            statement.setDate(3, Date.valueOf(timeEntry.getLocalDate()));
            statement.setLong(4,timeEntry.getHours());

            return  statement;
        },generatorKeyHolder);

       return find(generatorKeyHolder.getKey().longValue());
    }

    @Override
    public TimeEntry update(TimeEntry timeEntry, Long id) {

        jdbcTemplate.update("UPDATE time_entries set project_id = ?, user_id = ?, date=?, hours=? where id = ?",timeEntry.getProjectID(),
                timeEntry.getUserID(), timeEntry.getLocalDate(), timeEntry.getHours(),id);
        return find(id);
    }

    @Override
    public void delete(long id) {
            jdbcTemplate.update("Delete from time_entries where id=?",id);
    }

    @Override
    public TimeEntry find(long id) {
        return jdbcTemplate.query("SELECT id, project_id,user_id,date,hours FROM time_entries where id=?",new Object[]{id},extractor );
    }

    @Override
    public List<TimeEntry> list() {
        return  jdbcTemplate.query("select id, project_id,user_id,date,hours FROM time_entries",mapper);

    }

    private final RowMapper<TimeEntry> mapper =  (rs, rowNum) -> new TimeEntry(
                rs.getLong("id"),rs.getLong("project_id"),rs.getLong("user_id"),rs.getDate("date").toLocalDate(),rs.getInt("hours")
    );

private final ResultSetExtractor<TimeEntry> extractor = (rs )-> rs.next() ? mapper.mapRow(rs,1):null;


}
