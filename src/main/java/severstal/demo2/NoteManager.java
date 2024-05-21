package severstal.demo2;

import java.io.*;
import java.util.*;

public class NoteManager {
    private List<Note> notes;
    private static  final String FILE_PATH ="data/notes.txt";

    public NoteManager() {
        notes = new ArrayList<>();
        loadNotes();
        if(notes.isEmpty())
        {
            notes.add(new Note("You are greeted by the first note."));
            saveNotes();
        }

    }


    public void loadNotes()
    {
        File file=new File(FILE_PATH);
        if(!file.exists() || file.length() == 0)
        {
            return;
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH)))
        {
            notes=(List<Note>) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveNotes()
    {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                objectOutputStream.writeObject(notes);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void addNote(String note)
    {
        notes.add(new Note(note));
        saveNotes();
    }
    public void deleteNote(int index)
    {
        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            saveNotes();
        }
    }
    public void updateNote(int index, String newText)
    {
        notes.get(index).setText(newText);
        saveNotes();

    }
    public List<Note> getNotes()
    {
        return notes;
    }
}
