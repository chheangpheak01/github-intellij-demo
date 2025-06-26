package assignments.jdbc.assignment_1.test_JDBC;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class NoteApp extends JFrame {
    private Connection conn;
    private JButton addB, deleteB, updateB;
    private JList<String> noteList;
    private DefaultListModel<String> data;
    private Vector<Integer> noteId = new Vector<>();

    public NoteApp(){
        setTitle("This is my Note App");
        setSize(400,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        data = new DefaultListModel<>();
        noteList = new JList<>(data);
        noteList.setFont(new Font("Arial", Font.PLAIN, 15));
        noteList.setCellRenderer(new NoteRenderer());

        JScrollPane scroll = new JScrollPane(noteList);

        addB = new JButton("Add Note");
        deleteB = new JButton("Delete Note");
        updateB = new JButton("Update Note");

        JPanel jp = new JPanel();

        jp.add(addB);
        jp.add(deleteB);
        jp.add(updateB);

        add(jp, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        setupDB();
        loadAllNotes();

        addB.addActionListener(e -> addNewNote());
        deleteB.addActionListener(e -> deleteNote());
        updateB.addActionListener(e -> updateNote());
    }

    private void loadAllNotes(){
        noteId.clear();
        data.clear();
        String sql = "SELECT id, note_description, create_at FROM myNotes ORDER BY id";
        try(Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql))
        {
            while (res.next()){
                int id = res.getInt("id");
                String description = res.getString("note_description");
                Date created_date = res.getDate("create_at");
                noteId.add(id);
                data.addElement(description + ", " + created_date);
            }
            System.out.println("noteId -> " + noteId);
            System.out.println("data -> " + data);
            System.out.println("index -> " + noteList.getSelectedIndex());
        }catch (SQLException e){
            showError(e);
        }
    }

    private void setupDB(){
        String url = "jdbc:mysql://localhost:3306/java_final";
        String userName = "root";
        String password = "chph9771@gmail.com";
        try{
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("DB connected successfully, congratulation 😊👍🏾");
        }catch (SQLException e){
            showError(e);
        }
    }

    private void addNewNote(){
        JTextArea text = new JTextArea(10,20);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(text);

        int condition = JOptionPane.showConfirmDialog(
                this, scroll, "Add Note", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
        );
        if(condition == JOptionPane.OK_OPTION){
            String newNote = text.getText().trim();
            String sql = "INSERT INTO myNotes (note_description, create_at) VALUES (?,?)";
            if(!newNote.isEmpty()){
                try (PreparedStatement st = conn.prepareStatement(sql))
                {
                    st.setString(1, newNote);
                    st.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                    st.executeUpdate();
                    loadAllNotes();
                }catch (SQLException e){
                    showError(e);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Note can not be empty, please enter any text...");
        }
    }

    private void deleteNote(){
        int index = noteList.getSelectedIndex();
        if(index == -1){
            JOptionPane.showMessageDialog(this, "Please select any note to delete");
            return;
        }
        int condition = JOptionPane.showConfirmDialog(this, "Are you sure wanna delete it", "Please confirm", JOptionPane.YES_NO_OPTION);
        if(condition == JOptionPane.YES_OPTION){
            int id = noteId.get(index);
            System.out.println("id -> " + id);
            System.out.println("index -> " + index);
            try(PreparedStatement st = conn.prepareStatement("DELETE FROM myNotes WHERE id = ?")){
                st.setInt(1, id);
                st.executeUpdate();
                loadAllNotes();
            }catch (SQLException e){
                showError(e);
            }
        }
    }

    private void updateNote(){
        int index = noteList.getSelectedIndex();
        if(index == -1){
            JOptionPane.showMessageDialog(this, "Please select any note to delete...");
            return;
        }
        String newData = data.get(index);
        JTextArea newText = new JTextArea(newData, 10, 20);
        newText.setLineWrap(true);
        newText.setWrapStyleWord(true);

        JScrollPane scrollNewText = new JScrollPane(newText);

        int condition = JOptionPane.showConfirmDialog(this, scrollNewText,  "Update Note", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if(condition == JOptionPane.OK_OPTION){
            String newNote = newText.getText().trim();
            if(!newNote.isEmpty()){
                int id = noteId.get(index);
                String sql = "UPDATE myNotes SET note_description = ? WHERE id = ?";
                try(PreparedStatement st = conn.prepareStatement(sql)){
                    st.setString(1,newNote);
                    st.setInt(2, id);
                    st.executeUpdate();
                    loadAllNotes();
                }catch (SQLException e){
                    showError(e);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Note can not be empty");
            }
        }
    }

    static class NoteRenderer extends JTextArea implements ListCellRenderer<String>{
        public NoteRenderer(){
            setLineWrap(true);
            setWrapStyleWord(true);
            setOpaque(true);
        }
        @Override
        public Component getListCellRendererComponent(
                JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus){
            setFont(list.getFont());
            setSize(list.getWidth(), Short.MAX_VALUE);
            setText(value);
            setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
            if(isSelected){
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            }else{
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            return this;
        }
    }

    private void showError(SQLException e){
        StringBuilder sb = new StringBuilder("DB got error \n");
        while (e != null){
            sb.append("Message -> ").append(e.getMessage()).append("\n");
            sb.append("SQLState -> ").append(e.getSQLState()).append("\n");
            sb.append("ERROR Code -> ").append(e.getErrorCode()).append("\n");
            e = e.getNextException();
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NoteApp::new);
    }
}
