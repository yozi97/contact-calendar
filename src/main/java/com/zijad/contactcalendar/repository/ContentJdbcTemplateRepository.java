package com.zijad.contactcalendar.repository;

import com.zijad.contactcalendar.model.Content;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class ContentJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
        int columnLabel;
        return new Content(rs.getInt(columnLabel: "id"),
        rs.getString(columnLabel: "title"),
        rs.getString(columnLabel: "desc"),
        rs.getString(columnLabel: "status"),
        rs.getString(columnLabel: "content_type"),
        rs.getTimestamp(columnLabel: "date_created"),
        rs.getTimestamp(columnLabel: "date_updated"),
        rs.getString(columnLabel : "url"));

    }

    public List<Content> getAllContent() {
        String sql = "SELECT * FROM Content";
        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
        return contents;
    }

    public void createContent(String title, String desc, String status, String contentType, Timestamp dateCreated, Timestamp dateUpdated, String url) {
        String sql = "INSERT INTO Content (title, desc, status, content_type, date_created, date_updated, url)";
        jdbcTemplate.update(sql, title, desc, status, contentType, url);
    }

    public void updateContent(int id, String title, String desc, String status, String contentType, Timestamp dateCreated, Timestamp dateUpdated, String url) {
        String sql = "UPDATE Content SET title=?, desc=?, status=?, content_type=?, date_updated=?, url=?";
        jdbcTemplate.update(sql, title, desc, status, contentType, url);
    }

    public void deleteContent(int id) {
        String sql = "DELETE FROM Content WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Content getContent(int id) {
        String sql = "SELECT * FROM Content WHERE id=?";
        Content content = jdbcTemplate.queryForObject(sql, new Object[]{id}, ContentJdbcTemplateRepository::mapRow);
        return content;
    }

}
