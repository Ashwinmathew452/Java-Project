package com.library;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookSearchGUI extends JFrame {

    private JTextField searchField;
    private JTextArea resultArea;
    private JButton searchButton;

    private JTextField titleField;
    private JTextField authorField;
    private JTextField categoryField;
    private JTextField availabilityField;
    private JButton addButton;

    public BookSearchGUI() {

        setTitle("Find Your Book System");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ================= SEARCH PANEL =================
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        searchPanel.add(new JLabel("Search by Title or Author:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);

        searchButton = new JButton("Search");
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);

        // ================= RESULT AREA =================
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setPreferredSize(new Dimension(600, 200));

        add(scrollPane, BorderLayout.CENTER);

        // ================= ADD BOOK PANEL =================
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add New Book"));

        formPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        formPanel.add(titleField);

        formPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        formPanel.add(authorField);

        formPanel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        formPanel.add(categoryField);

        formPanel.add(new JLabel("Availability:"));
        availabilityField = new JTextField();
        formPanel.add(availabilityField);

        formPanel.add(new JLabel(""));
        addButton = new JButton("Add Book");
        formPanel.add(addButton);

        add(formPanel, BorderLayout.SOUTH);

        // ================= BUTTON ACTIONS =================
        searchButton.addActionListener(e -> searchBook());
        addButton.addActionListener(e -> addBook());

        setLocationRelativeTo(null); // Center window
        setVisible(true);
    }

    // ================= SEARCH LOGIC =================
    private void searchBook() {

        String keyword = searchField.getText().trim();

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Search field cannot be empty!");
            return;
        }

        new Thread(() -> searchFromDatabase(keyword)).start();
    }

    private void searchFromDatabase(String keyword) {

        StringBuilder result = new StringBuilder();
        boolean found = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                found = true;

                result.append("ID: ").append(rs.getInt("id")).append("\n");
                result.append("Title: ").append(rs.getString("title")).append("\n");
                result.append("Author: ").append(rs.getString("author")).append("\n");
                result.append("Category: ").append(rs.getString("category")).append("\n");
                result.append("Availability: ").append(rs.getString("availability")).append("\n");
                result.append("------------------------------------------------\n");
            }

            con.close();

        } catch (Exception e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(this, "Search Error: " + e.getMessage())
            );
            return;
        }

        final boolean finalFound = found;
        final String finalResult = result.toString();

        SwingUtilities.invokeLater(() -> {
            if (finalFound) {
                resultArea.setText(finalResult);
            } else {
                resultArea.setText("No book found.");
            }
        });
    }

    // ================= INSERT LOGIC =================
    private void addBook() {

        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String category = categoryField.getText().trim();
        String availability = availabilityField.getText().trim();

        if (title.isEmpty() || author.isEmpty() || category.isEmpty() || availability.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return;
        }

        new Thread(() -> insertIntoDatabase(title, author, category, availability)).start();
    }

    private void insertIntoDatabase(String title, String author, String category, String availability) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO books (title, author, category, availability) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, title);
            pst.setString(2, author);
            pst.setString(3, category);
            pst.setString(4, availability);

            pst.executeUpdate();
            con.close();

            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(this, "Book Added Successfully!");

                titleField.setText("");
                authorField.setText("");
                categoryField.setText("");
                availabilityField.setText("");
            });

        } catch (Exception e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(this, "Insert Error: " + e.getMessage())
            );
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BookSearchGUI::new);
    }
}
