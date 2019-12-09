package io.pivotal.pal.tracker.pivotalarchana;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    HashMap<Long, TimeEntry> timeEntriesMap = new HashMap<Long,TimeEntry>();

    private long currentID = 1;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        long id = currentID++;
        TimeEntry newTimeEntry = new TimeEntry(id, timeEntry.getProjectID(),timeEntry.getUserID(), timeEntry.getLocalDate(),timeEntry.getHours());

        timeEntriesMap.put(id,newTimeEntry);
        return newTimeEntry;
    }

    @Override
    public TimeEntry update(TimeEntry timeEntry, Long id) {
        if(timeEntriesMap.get(id) == null){
                return null;
        }else{
            TimeEntry newTimeEntry = new TimeEntry(id,timeEntry.getProjectID(),timeEntry.getUserID(),timeEntry.getLocalDate(),timeEntry.getHours());
           timeEntriesMap.replace(id, newTimeEntry);
            return newTimeEntry;
        }
    }

    @Override
    public void delete(long id) {

            timeEntriesMap.remove(id);

    }

    @Override
    public TimeEntry find(long id) {
        return timeEntriesMap.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntriesMap.values());
    }
}
