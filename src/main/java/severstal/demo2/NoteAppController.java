package severstal.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.HTMLEditor;

import java.util.List;
import java.util.Optional;

public class NoteAppController {
    public ListView<Note> notesListView;
    public TextField noteTextField;
    private final NoteManager noteManager = new NoteManager();

    @FXML
    public void initialize() {

        refreshNotesList();

    }
    private void refreshNotesList() {
        ObservableList<Note> items = FXCollections.observableArrayList(noteManager.getNotes());
        notesListView.setItems(items);
    }

    @FXML
    public void handleAddNote() {
        noteManager.addNote(noteTextField.getText());
        refreshNotesList();
        noteTextField.clear();
    }

    @FXML
    public void handleDeleteNote() {
        Alert conf = new Alert(Alert.AlertType.CONFIRMATION);
        conf.setTitle("Подтверждение");
        conf.setHeaderText(null);
        conf.setContentText("Вы точно хотите удалить эту заметку?");
        Optional<ButtonType> action = conf.showAndWait();
        if ((action.isPresent()) && (action.get() == ButtonType.OK)) {
            noteManager.deleteNote(notesListView.getSelectionModel().getSelectedIndex());
            refreshNotesList();
        }

    }

    public void handleEditNote(ActionEvent actionEvent) {
        noteManager.updateNote(notesListView.getSelectionModel().getSelectedIndex(),noteTextField.getText());
        refreshNotesList();

    }
}
