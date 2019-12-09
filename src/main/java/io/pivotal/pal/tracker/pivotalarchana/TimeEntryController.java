package io.pivotal.pal.tracker.pivotalarchana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries/")
public class TimeEntryController {


    @Autowired
    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {

        TimeEntry newTimeEntry  = timeEntryRepository.create(timeEntry);
        ResponseEntity responseEntity =  new ResponseEntity<>(newTimeEntry, HttpStatus.CREATED);
        return responseEntity;

    }

    @PutMapping("{id}")
    public ResponseEntity update( @RequestBody TimeEntry timeEntry,@PathVariable Long id) {

        TimeEntry newTimeEntry = timeEntryRepository.update(timeEntry,id);
        if(newTimeEntry!=null){
            return new ResponseEntity<>(newTimeEntry,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("{id}")

     public ResponseEntity delete(@PathVariable long id) {

        timeEntryRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @GetMapping("{id}")
    public ResponseEntity find(@PathVariable  long id) {

        TimeEntry timeEntry = timeEntryRepository.find(id);
        if(timeEntry !=null){

           return new ResponseEntity<>(timeEntry, HttpStatus.OK);

        }else{

            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }


    }

    @GetMapping
     public ResponseEntity<List<TimeEntry> >list() {

        List<TimeEntry> timeEntryList = timeEntryRepository.list();

        return new ResponseEntity<>(timeEntryList,HttpStatus.OK);
    }
}
