package io.pivotal.pal.tracker.pivotalarchana;

import java.util.List;

public interface TimeEntryRepository  {

   TimeEntry create(TimeEntry timeEntry);
   TimeEntry update(TimeEntry timeEntry, Long id);
   void delete(long id);
   TimeEntry find(long id);
   List<TimeEntry> list();

}
