package com.ufms.progweb.services;

import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void criptografarSenha(Long id, String novaSenha) {
        String senhaCriptografada = passwordEncoder.encode(novaSenha);
        String url = "jdbc:postgresql://localhost:5432/progwebdb";
        String user = "postgres";
        String password = "mur123";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement selectStmt = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
             PreparedStatement updateStmt = connection.prepareStatement("UPDATE users SET password = ? WHERE id = ?")) {
            
            selectStmt.setLong(1, id);
            ResultSet resultSet = selectStmt.executeQuery();

            if (resultSet.next()) {
                updateStmt.setString(1, senhaCriptografada);
                updateStmt.setLong(2, id);
                updateStmt.executeUpdate();
            } else {
                throw new SQLException("Usuário não encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
