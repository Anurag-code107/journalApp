//package net.engineeringdigest.journalApp.controller;
//
//import net.engineeringdigest.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import  java.util.Map;
//import  java.util.List;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//
//    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping()
//    public List<JournalEntry> getAll() //GET localhost:8282/journal
//    {
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry)
//    {
//        journalEntries.put(myEntry.getId(), myEntry);
//        return true;
//    }
//
//    @GetMapping("/id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable Long myId)
//    {
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("/id/{myId}")
//    public JournalEntry deleteJournalById(@PathVariable Long myId)
//    {
//        return journalEntries.remove(myId);
//    }
//
//    @PutMapping("id/{id}")
//    public JournalEntry updateJournalById(@PathVariable long id, @RequestBody JournalEntry myEntry)
//    {
//        return journalEntries.put(id, myEntry);
//    }
//}
